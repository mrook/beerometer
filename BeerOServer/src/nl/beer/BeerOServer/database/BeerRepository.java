package nl.beer.BeerOServer.database;

import java.util.List;

import nl.beer.BeerOServer.model.Beer;

public interface BeerRepository {
	public List<Beer> getAllBeers();

	public void addBeer(Beer beer);
}
