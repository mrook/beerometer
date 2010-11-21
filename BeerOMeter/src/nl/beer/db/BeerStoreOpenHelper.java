package nl.beer.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BeerStoreOpenHelper extends SQLiteOpenHelper {
	public static final String TABLE_NAME = "beeritem";

	public static final String KEY_NAME = "name";
	public static final String KEY_PERCENTAGE = "percentage";
	public static final String KEY_GRADE = "grade";

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "beerstore.db";	

	private static final String TABLE_CREATE =
		  "CREATE TABLE " + TABLE_NAME + " (" +
          KEY_NAME + " TEXT, " +
          KEY_PERCENTAGE + " REAL, " +
          KEY_GRADE + " REAL);";
	
	public BeerStoreOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
