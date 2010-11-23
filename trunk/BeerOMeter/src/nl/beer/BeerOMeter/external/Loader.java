package nl.beer.BeerOMeter.external;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import nl.beer.BeerOMeter.model.BeerItem;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Loader {
	public final static String LOCATION = "http://beer-o-meter.appspot.com/beerservice";

    static final String NAME = "name";
    static final String PERCENTAGE = "percentage";
    static final String GRADE = "grade";
    
	public Loader() {
	}
	
	public Vector<BeerItem> parse() {
		Vector<BeerItem> items = new Vector<BeerItem>();
		
		String result = query(LOCATION);
		
		try {
			JSONArray jsonItems = new JSONArray(result);
			
			for (int i = 0; i < jsonItems.length(); i++) {
				JSONObject obj = jsonItems.getJSONObject(i);
				
				BeerItem item = new BeerItem();
				item.setName(obj.getString(NAME));
				item.setPercentage(obj.getString(PERCENTAGE));
				item.setGrade(obj.getString(GRADE));
				
				items.add(item);
			}
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
		
		return items;
	}
	
	private String query(String url) {  
	    HttpClient client = new DefaultHttpClient();  
	    HttpGet request = new HttpGet(url);
	    ResponseHandler<String> handler = new BasicResponseHandler();
	      
        String result;
		try {
			result = client.execute(request, handler);
			
	        Log.i("REST", "Status:[" + result + "]");
	        return result;
		} catch (ClientProtocolException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}  
}
