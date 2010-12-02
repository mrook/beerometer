package nl.beer.BeerOServer.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nl.beer.BeerOServer.controller.BeerController;
import nl.beer.BeerOServer.controller.BeerControllerImpl;
import nl.beer.BeerOServer.model.Beer;

@Path("/beerlist")
public class BeerListResource {
	// TODO: Use dependency injection :)
	private BeerController beerController; 
	
	public BeerListResource() {
		beerController = new BeerControllerImpl();
	}
	
	@GET
	@Produces("application/json")
	public List<Beer> retrieve() {
		return beerController.getAllBeers();
	}
	
}