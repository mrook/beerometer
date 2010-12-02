package nl.beer.BeerOServer.controller;

import java.util.List;

import nl.beer.BeerOServer.database.BeerRepository;
import nl.beer.BeerOServer.database.BeerRepositoryJdoImpl;
import nl.beer.BeerOServer.model.Beer;

public class BeerControllerImpl implements BeerController {
	// TODO: Use dependency injection :)
	private BeerRepository beerRepository; 
	
	public BeerControllerImpl() {
		beerRepository = new BeerRepositoryJdoImpl();
	}
	
	@Override
	public List<Beer> getAllBeers() {
		return beerRepository.getAllBeers();
	}
	
	@Override
	public void addBeer(Beer beer) {
		beerRepository.addBeer(beer);
	}

}
