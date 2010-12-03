package nl.beer.BeerOServer;

import nl.beer.BeerOServer.controller.BeerController;
import nl.beer.BeerOServer.controller.BeerControllerImpl;
import nl.beer.BeerOServer.database.BeerRepository;
import nl.beer.BeerOServer.database.BeerRepositoryJdoImpl;

import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {
	public GuiceModule() {
	}

	@Override
	public void configure() {
		bind(BeerController.class).to(BeerControllerImpl.class);
		bind(BeerRepository.class).to(BeerRepositoryJdoImpl.class);
	}
}
