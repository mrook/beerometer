package nl.beer.BeerOMeter.activities;

import nl.beer.BeerOMeter.R;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class ExternalViewActivity extends Activity {
	WebView webView;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main_externalview);

	    webView = (WebView) findViewById(R.id.webview);
	    webView.getSettings().setJavaScriptEnabled(true);
	    webView.loadUrl("http://www.mjchermans.nl/bieren/bier.asp?name=530");
	}
}
