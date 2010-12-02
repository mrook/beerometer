package nl.beer.BeerOServer.controller;

import java.util.List;

import nl.beer.BeerOServer.model.Beer;

public interface BeerController {
	public List<Beer> getAllBeers();

	public void addBeer(Beer beer);
}
