package nl.beer.BeerOMeter.external;

import java.io.IOException;
import java.util.Vector;

import nl.beer.BeerOMeter.model.BeerItem;

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

	//public final static String LOCATION = "http://10.0.2.2:8888/beers";
	public final static String LOCATION = "http://beer-o-server.appspot.com/beerlist";

    static final String NAME = "name";
    static final String PERCENTAGE = "percentage";
    static final String GRADE = "grade";
    
	public Loader() {
	}
	
	public Vector<BeerItem> parse() {
		Vector<BeerItem> items = new Vector<BeerItem>();
		
		String result = query(LOCATION);
		
		try {
			JSONObject mainJsonObject = new JSONObject(result);
			
			JSONArray beers = mainJsonObject.getJSONArray("beer");
			for (int i = 0; i < beers.length(); i++) {
				JSONObject obj = beers.getJSONObject(i);
				
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
