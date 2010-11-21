package nl.beer.utils;

import java.util.Collections;

import android.app.ProgressDialog;

import nl.beer.activities.BeerListActivity;
import nl.beer.external.Loader;
import nl.beer.model.BeerStore;

public class Synchronizer {
	public static void synchronize()
	{
		BeerStore beerStore = BeerStore.getInstance();
		
		beerStore.clear();
		
		Loader loader = new Loader();
		
		beerStore.addAll(loader.parse());
		
		Collections.sort(beerStore);
	}
}
