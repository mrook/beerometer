package nl.beer.BeerOMeter.activities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import nl.beer.BeerOMeter.R;
import nl.beer.BeerOMeter.db.ExternalStorageHelper;
import nl.beer.BeerOMeter.model.BeerItem;
import nl.beer.BeerOMeter.model.BeerStore;
import nl.beer.BeerOMeter.utils.Synchronizer;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class BeerListActivity extends ListActivity {
	public final static int VIEW_EXCEPTION = 0xf0f0;
	public final static int VIEW_UPDATE    = 0xf0f1;
	
	public final static String ITEM_TITLE = "title";
    public final static String ITEM_PERCENTAGE = "caption";
    public final static String ITEM_GRADE = "grade";
	    
	private List<Map<String,?>> beerList;
	private SimpleAdapter beerAdapter;
	private ProgressDialog progressDialog;
	
	private static class BeerListAdapter extends SimpleAdapter {
		BeerListAdapter(Context context, List<Map<String,?>> list) {
			super(context, list, R.layout.beer_list2,  
                new String[] { ITEM_TITLE, ITEM_PERCENTAGE, ITEM_GRADE }, new int[] { R.id.list_complex_title, R.id.list_complex_percentage, R.id.list_complex_grade });
		}
	}
	
	private void updateBeerList() {
		beerList.clear();
		
		Iterator<BeerItem> iterator = BeerStore.getInstance().iterator();
		
		while (iterator.hasNext()) {
			BeerItem item = iterator.next();

        	Map<String,String> map = new HashMap<String,String>();  
            map.put(ITEM_TITLE, item.getName());  
            map.put(ITEM_PERCENTAGE, item.getPercentage().toString() + "%");
            map.put(ITEM_GRADE, item.getGrade().toString());				

        	beerList.add(map);
		}      
	}
	
	private final Handler handler = new Handler() {
	    @Override
	    public void handleMessage(final Message msg) {
	        switch (msg.what) {
	        case BeerListActivity.VIEW_EXCEPTION:
    			AlertDialog.Builder builder = new AlertDialog.Builder(BeerListActivity.this);
    			builder.setTitle("An exception occurred:")
    			       .setNeutralButton("Close", new DialogInterface.OnClickListener() {
    			           public void onClick(DialogInterface dialog, int id) {
    			                dialog.cancel();
    			           }
    			       })
    				   .setMessage(((Exception) msg.obj).getMessage());
    			AlertDialog alert = builder.create();
    			alert.show();
	        	break;
	        case BeerListActivity.VIEW_UPDATE:
	            beerAdapter.notifyDataSetChanged();
	            break;
	        default:
	        }
	        
	        // dismiss dialog
        	if (progressDialog != null) {
        		progressDialog.dismiss();
        	}
	    }
	};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        beerList = new LinkedList<Map<String,?>>();
        
        beerAdapter = new BeerListAdapter(this, beerList);
        
        setListAdapter(beerAdapter);
        
        ExternalStorageHelper.pull(this);
        
        updateBeerList();
        
        handler.sendEmptyMessage(BeerListActivity.VIEW_UPDATE);
        
        setContentView(R.layout.main);
        
        Resources res = getResources();
        Drawable shape = res. getDrawable(R.drawable.divider);
        getListView().setDivider(shape);
        getListView().setDividerHeight(2);
    }
    
    @Override
    public void onStop() {
    	super.onStop();
    	
    	ExternalStorageHelper.push(this);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.sync:
    		progressDialog = ProgressDialog.show(this, "", "Loading...", true);
    		
            new Thread(new Runnable(){
            	public void run() {
            		try {
	            		Synchronizer.synchronize();
	            		
	            		ExternalStorageHelper.push(BeerListActivity.this);
	            		
	            		updateBeerList();
        			} catch (Exception e) {
            			handler.sendMessage(Message.obtain(handler, BeerListActivity.VIEW_EXCEPTION, e));
            		}            		

					handler.sendEmptyMessage(BeerListActivity.VIEW_UPDATE);
            	}
        	}).start();
    		
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    @Override
    public void onListItemClick(ListView l, View view, int position, long id) {
    	startActivity(new Intent(view.getContext(), ExternalViewActivity.class));    	
    }
}