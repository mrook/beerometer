package nl.beer.BeerOMeter.utils;

import java.util.Collections;

import nl.beer.BeerOMeter.external.Loader;
import nl.beer.BeerOMeter.model.BeerStore;

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
