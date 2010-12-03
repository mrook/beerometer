package nl.beer.BeerImporter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import nl.beer.BeerOServer.model.Beer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class BeerImporter {

	public static void main(String[] args) throws IOException {
		Client client = Client.create();
		WebResource webResource = client.resource("http://beer-o-server.appspot.com/beer");
		
		Scanner fileScanner = new Scanner(new File("res/beerlist.txt"));
		
		while(fileScanner.hasNextLine()) {
			Scanner beerScanner = new Scanner(fileScanner.nextLine()).useDelimiter(",");
			
			String name = beerScanner.next();
			float percentage = Float.parseFloat(beerScanner.next());
			float grade = Float.parseFloat(beerScanner.next());
			
			Beer beer = new Beer(name, percentage, grade);
			
			System.out.println(String.format("Adding beer %s, %f, %f", name, percentage, grade));
			
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, beer);
			
			System.out.println(response.toString());
		}
		
		System.out.println("Done");
	}
}
