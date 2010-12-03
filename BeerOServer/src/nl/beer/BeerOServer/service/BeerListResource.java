package nl.beer.BeerOServer.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Inject;

import nl.beer.BeerOServer.controller.BeerController;
import nl.beer.BeerOServer.model.Beer;

@Path("/beerlist")
public class BeerListResource {
	private BeerController beerController;

	@Inject
	public BeerListResource(BeerController beerController) {
		this.beerController = beerController;
	}

	@GET
	@Produces("application/json")
	public List<Beer> retrieve() {
		return beerController.getAllBeers();
	}
}