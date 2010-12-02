package nl.beer.BeerOServer.database;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import nl.beer.BeerOServer.model.Beer;

public class BeerRepositoryJdoImpl implements BeerRepository {

	@Override
	@SuppressWarnings("unchecked")
	public List<Beer> getAllBeers() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Query query = pm.newQuery(Beer.class);
			try {
				List<Beer> beers = (List<Beer>) query.execute();
				
				System.out.println("Found " + beers.size() + " beers");
				
				return beers;
			}
			finally {
				query.closeAll();
			}
		}
		finally {
			pm.close();
		}
	}

	@Override
	public void addBeer(Beer beer) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(beer);
		}
		finally {
			pm.close();
		}
	}
}
