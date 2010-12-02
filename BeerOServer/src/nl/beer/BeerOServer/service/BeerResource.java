package nl.beer.BeerOServer.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import nl.beer.BeerOServer.controller.BeerController;
import nl.beer.BeerOServer.controller.BeerControllerImpl;
import nl.beer.BeerOServer.model.Beer;

@Path("/beer")
public class BeerResource {
	// TODO: Use dependency injection :)
	private BeerController beerController; 
	
	public BeerResource() {
		beerController = new BeerControllerImpl();
	}
	
	@POST
	@Consumes("application/json")
	public void add(Beer beer){
		beerController.addBeer(beer);
	}
}
