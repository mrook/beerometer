package nl.beer.BeerOServer.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.inject.Inject;

import nl.beer.BeerOServer.controller.BeerController;
import nl.beer.BeerOServer.model.Beer;

@Path("/beer")
public class BeerResource {
	private BeerController beerController; 
	
	@Inject
	public BeerResource(BeerController beerController) {
		this.beerController = beerController;
	}
	
	@POST
	@Consumes("application/json")
	public void add(Beer beer){
		beerController.addBeer(beer);
	}
}
