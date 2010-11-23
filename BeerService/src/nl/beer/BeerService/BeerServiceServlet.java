package nl.beer.BeerService;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class BeerServiceServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("[{\"name\":\"Affligem Tripel\",\"percentage\":\"8.5\",\"grade\":\"9\"},{\"name\":\"Alfa\",\"percentage\":\"5\",\"grade\":\"7\"},{\"name\":\"Amstel 1870\",\"percentage\":\"5\",\"grade\":\"7\"},{\"name\":\"Arabier\",\"percentage\":\"7.5\",\"grade\":\"8.5\"},{\"name\":\"Augustijn\",\"percentage\":\"8\",\"grade\":\"8\"},{\"name\":\"Barbar\",\"percentage\":\"8\",\"grade\":\"7.75\"},{\"name\":\"Boon Kriek\",\"percentage\":\"4.5\",\"grade\":\"5\"},{\"name\":\"Boon Geuze\",\"percentage\":\"4.5\",\"grade\":\"4\"},{\"name\":\"Bornem Dubbel\",\"percentage\":\"7\",\"grade\":\"8\"},{\"name\":\"Bornem Tripel\",\"percentage\":\"11.5\",\"grade\":\"8.5\"},{\"name\":\"Bosbier\",\"percentage\":\"4.5\",\"grade\":\"6.5\"},{\"name\":\"Bourgogne des Fl\",\"percentage\":\"5\",\"grade\":\"7.5\"},{\"name\":\"Brand Up\",\"percentage\":\"5.5\",\"grade\":\"6.75\"},{\"name\":\"Brigand\",\"percentage\":\"9\",\"grade\":\"7.75\"},{\"name\":\"Brugse Blond\",\"percentage\":\"6\",\"grade\":\"8.75\"},{\"name\":\"Brugse Tripel\",\"percentage\":\"9\",\"grade\":\"7.75\"},{\"name\":\"Budvar\",\"percentage\":\"5\",\"grade\":\"6.25\"},{\"name\":\"Bush Beer\",\"percentage\":\"12\",\"grade\":\"8\"},{\"name\":\"Carlsberg\",\"percentage\":\"4\",\"grade\":\"7.5\"},{\"name\":\"Charles Quint\",\"percentage\":\"9\",\"grade\":\"7\"},{\"name\":\"Chimay Dubbel\",\"percentage\":\"7\",\"grade\":\"6.25\"},{\"name\":\"Chimay Quint\",\"percentage\":\"9\",\"grade\":\"7\"},{\"name\":\"Chimay Speciaal\",\"percentage\":\"9\",\"grade\":\"6\"},{\"name\":\"Chimay Tripel\",\"percentage\":\"11.6\",\"grade\":\"6.5\"},{\"name\":\"Christoffel Blond\",\"percentage\":\"5.5\",\"grade\":\"7\"},{\"name\":\"Ciney Blonde\",\"percentage\":\"7\",\"grade\":\"7.5\"},{\"name\":\"Ciney Speciale\",\"percentage\":\"9\",\"grade\":\"7.75\"},{\"name\":\"Columbus\",\"percentage\":\"9\",\"grade\":\"7.5\"},{\"name\":\"Corona\",\"percentage\":\"4.5\",\"grade\":\"7.5\"},{\"name\":\"Corsendonk Agnus\",\"percentage\":\"7\",\"grade\":\"6.75\"},{\"name\":\"Corsendonk Pater\",\"percentage\":\"7.5\",\"grade\":\"8\"},{\"name\":\"DAB\",\"percentage\":\"5\",\"grade\":\"7.5\"},{\"name\":\"Delerium Tremens\",\"percentage\":\"9\",\"grade\":\"7.75\"},{\"name\":\"Desperados\",\"percentage\":\"5.9\",\"grade\":\"8.25\"},{\"name\":\"Deugniet\",\"percentage\":\"7.7\",\"grade\":\"7\"},{\"name\":\"Dom Blondje\",\"percentage\":\"5\",\"grade\":\"8\"},{\"name\":\"Duvel\",\"percentage\":\"8.5\",\"grade\":\"7\"},{\"name\":\"Ename Tripel\",\"percentage\":\"9\",\"grade\":\"7.5\"},{\"name\":\"Erdingen Hefe Weiss\",\"percentage\":\"5.5\",\"grade\":\"7.5\"},{\"name\":\"Flierefluiter\",\"percentage\":\"7\",\"grade\":\"7\"},{\"name\":\"Fosters\",\"percentage\":\"8\",\"grade\":\"7\"},{\"name\":\"Gentse Tripel\",\"percentage\":\"8\",\"grade\":\"6.25\"},{\"name\":\"Gordon Scotch\",\"percentage\":\"8.6\",\"grade\":\"8\"},{\"name\":\"Gouden Carolus\",\"percentage\":\"8.5\",\"grade\":\"7.5\"},{\"name\":\"Guillotine\",\"percentage\":\"8\",\"grade\":\"8\"},{\"name\":\"Grimbergen Dubbel\",\"percentage\":\"6.5\",\"grade\":\"7.5\"},{\"name\":\"Grimbergen Tripel\",\"percentage\":\"9\",\"grade\":\"7.5\"},{\"name\":\"Grimbergen Opt Br\",\"percentage\":\"10\",\"grade\":\"8.5\"},{\"name\":\"Grolsch Beugel\",\"percentage\":\"5\",\"grade\":\"7.5\"},{\"name\":\"Gulden Draak\",\"percentage\":\"10.5\",\"grade\":\"7.5\"},{\"name\":\"Hertog Jan Primator\",\"percentage\":\"6\",\"grade\":\"6.5\"},{\"name\":\"Hertog Jan Pilsener\",\"percentage\":\"5\",\"grade\":\"7.5\"},{\"name\":\"Hertog Jan Tripel\",\"percentage\":\"8.5\",\"grade\":\"6.75\"},{\"name\":\"Hertog Jan Gr Pr\",\"percentage\":\"10\",\"grade\":\"7\"},{\"name\":\"Hoegaarden Grand Cru\",\"percentage\":\"8.5\",\"grade\":\"8\"},{\"name\":\"Hommel\",\"percentage\":\"2\",\"grade\":\"7\"},{\"name\":\"Houten Kop\",\"percentage\":\"6.5\",\"grade\":\"8\"},{\"name\":\"Julius\",\"percentage\":\"8.8\",\"grade\":\"7.5\"},{\"name\":\"Judas\",\"percentage\":\"8.5\",\"grade\":\"7.5\"},{\"name\":\"Kapittel Abt\",\"percentage\":\"10\",\"grade\":\"7\"},{\"name\":\"Kapittel Prior\",\"percentage\":\"9\",\"grade\":\"5.5\"},{\"name\":\"Kapittel Pater\",\"percentage\":\"6\",\"grade\":\"7.5\"},{\"name\":\"Kasteelbier Donker\",\"percentage\":\"11\",\"grade\":\"8.5\"},{\"name\":\"Kasteel Tripel\",\"percentage\":\"11\",\"grade\":\"8.5\"},{\"name\":\"Kilkenny\",\"percentage\":\"5\",\"grade\":\"6\"},{\"name\":\"Koninck Cuvee\",\"percentage\":\"8\",\"grade\":\"7.5\"},{\"name\":\"Korenwolf\",\"percentage\":\"5\",\"grade\":\"8\"},{\"name\":\"Kwel Chouffe\",\"percentage\":\"8.5\",\"grade\":\"7\"},{\"name\":\"La Trappe Tripel\",\"percentage\":\"8\",\"grade\":\"8\"},{\"name\":\"Leffe Radieuse\",\"percentage\":\"8.5\",\"grade\":\"7.5\"},{\"name\":\"Leffe Tripel\",\"percentage\":\"8.5\",\"grade\":\"7\"},{\"name\":\"Lindemans Frambozen\",\"percentage\":\"4.5\",\"grade\":\"7.5\"},{\"name\":\"Lindemans G Band\",\"percentage\":\"8\",\"grade\":\"7.5\"},{\"name\":\"Lindemans Faro\",\"percentage\":\"4\",\"grade\":\"6.5\"},{\"name\":\"Lucifer\",\"percentage\":\"8\",\"grade\":\"7.5\"},{\"name\":\"Maredsous 10\",\"percentage\":\"10\",\"grade\":\"7.5\"},{\"name\":\"Maredsous 8\",\"percentage\":\"8\",\"grade\":\"6.75\"},{\"name\":\"Maes Pils\",\"percentage\":\"4.9\",\"grade\":\"7\"},{\"name\":\"Moeder Overste\",\"percentage\":\"8\",\"grade\":\"6.75\"},{\"name\":\"Mongozo\",\"percentage\":\"7\",\"grade\":\"7\"},{\"name\":\"Oerbier\",\"percentage\":\"7.5\",\"grade\":\"5.75\"},{\"name\":\"Orval\",\"percentage\":\"6.2\",\"grade\":\"6.5\"},{\"name\":\"Oud Zottegems\",\"percentage\":\"6.5\",\"grade\":\"8\"},{\"name\":\"Pauwel Kwak\",\"percentage\":\"8\",\"grade\":\"8\"},{\"name\":\"Petrus Tripel\",\"percentage\":\"7.5\",\"grade\":\"7.75\"},{\"name\":\"Pilsner Urquell\",\"percentage\":\"4.5\",\"grade\":\"7.75\"},{\"name\":\"Piraat\",\"percentage\":\"9\",\"grade\":\"8\"},{\"name\":\"Rochefort 8\",\"percentage\":\"9.2\",\"grade\":\"7.5\"},{\"name\":\"Walbier\",\"percentage\":\"5\",\"grade\":\"7.75\"},{\"name\":\"Texels Wit\",\"percentage\":\"5\",\"grade\":\"8\"},{\"name\":\"Texels Amber\",\"percentage\":\"5.5\",\"grade\":\"8.5\"},{\"name\":\"Texels Goud\",\"percentage\":\"5\",\"grade\":\"7.5\"},{\"name\":\"Texels Tripel\",\"percentage\":\"8.5\",\"grade\":\"0\"},{\"name\":\"Texels Skuumkoppe\",\"percentage\":\"6\",\"grade\":\"8\"},{\"name\":\"Texels Bock\",\"percentage\":\"7.5\",\"grade\":\"7\"}]");
	}
}
