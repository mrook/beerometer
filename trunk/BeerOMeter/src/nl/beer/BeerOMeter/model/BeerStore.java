package nl.beer.BeerOMeter.model;

import java.util.Iterator;
import java.util.Vector;

public final class BeerStore extends Vector<BeerItem> {
	/**
	 * Serial UUID 
	 */
	private static final long serialVersionUID = 5703912484311358175L;
	
	public static final String STORE_NAME = "BeerOMeter";
	private static BeerStore beerStoreInstance = null;

	public static BeerStore getInstance() {
		if (beerStoreInstance == null) {
			beerStoreInstance = new BeerStore();
		}
		
		return beerStoreInstance;
	}
	
	public String[] getBeerNames() {
		String[] names = new String[size()];
		
		for (int idx = 0; idx < size(); idx++) {
			BeerItem item = (BeerItem) get(idx);
			
			names[idx] = new String(item.getName());
		}
		
		return names;
	}

	public BeerItem containsBeer(String beerName) {
		Iterator<BeerItem> itemIterator = iterator();
		
		while (itemIterator.hasNext()) {
			BeerItem item = (BeerItem) itemIterator.next();
			
			if (item.getName().equals(beerName))
				return item;
		}
		
		throw new RuntimeException("Unable to find beer '" + beerName + "'");
	}

	@Override
	public String toString() {
		String result = ""; 
		
		Iterator<BeerItem> itemIterator = iterator();
		
		while (itemIterator.hasNext()) {
			BeerItem item = (BeerItem) itemIterator.next();

			result += item.toString() + "\n";
		}
		
		return result; 
	}
}
