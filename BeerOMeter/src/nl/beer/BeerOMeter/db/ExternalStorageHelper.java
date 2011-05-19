package nl.beer.BeerOMeter.db;

import java.util.Iterator;

import nl.beer.BeerOMeter.model.BeerItem;
import nl.beer.BeerOMeter.model.BeerStore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ExternalStorageHelper {
	public static void pull(Context context) {
		BeerStore beerStore = BeerStore.getInstance();
		
		beerStore.clear();
		
		SQLiteDatabase db = (new BeerStoreOpenHelper(context)).getReadableDatabase();
		
		Cursor cursor = db.query(BeerStoreOpenHelper.TABLE_NAME, 
				new String[] {BeerStoreOpenHelper.KEY_NAME, BeerStoreOpenHelper.KEY_PERCENTAGE, BeerStoreOpenHelper.KEY_GRADE}, 
                null, null, null, null, null);

		if (cursor.moveToFirst()) {
			do {
				BeerItem item = new BeerItem();
				item.setName(cursor.getString(0));
				item.setPercentage(cursor.getString(1));
				item.setGrade(cursor.getString(2));
				
				beerStore.add(item);
			} while (cursor.moveToNext());
			
			if (cursor != null && !cursor.isClosed()) {
				cursor.close();
			}
		}
		
		db.close();
	}
	
	public static void push(Context context) {
		BeerStore beerStore = BeerStore.getInstance();
		SQLiteDatabase db = (new BeerStoreOpenHelper(context)).getWritableDatabase();
		
		db.beginTransaction();
		
		db.delete(BeerStoreOpenHelper.TABLE_NAME, null, null);
		
		Iterator<BeerItem> iterator = beerStore.iterator();
		
		while (iterator.hasNext()) { 
			BeerItem item = iterator.next();
			
			ContentValues values = new ContentValues();
			values.put(BeerStoreOpenHelper.KEY_NAME, item.getName());
			values.put(BeerStoreOpenHelper.KEY_PERCENTAGE, item.getPercentage());
			values.put(BeerStoreOpenHelper.KEY_GRADE, item.getGrade());
			
			db.insert(BeerStoreOpenHelper.TABLE_NAME, null, values);
		}
		
		db.setTransactionSuccessful();
		
		db.endTransaction();
		
		db.close();
	}
}
