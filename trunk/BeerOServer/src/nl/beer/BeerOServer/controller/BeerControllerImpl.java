package nl.beer.BeerOServer.controller;

import java.util.List;

import nl.beer.BeerOServer.database.BeerRepository;
import nl.beer.BeerOServer.model.Beer;

import com.google.inject.Inject;

public class BeerControllerImpl implements BeerController {
	private BeerRepository beerRepository;

	@Inject
	public BeerControllerImpl(BeerRepository beerRepository) {
		this.beerRepository = beerRepository;
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
