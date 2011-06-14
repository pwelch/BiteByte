package com.welch.bitebyte;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/** WebView Activity to display Places/Map */
public class Browser extends Activity {
	// Create WebView 
	private WebView webView;
	 
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.browser);
      
      // Set WebView by id
      webView = (WebView) findViewById(R.id.web_view);
      // Method to call WebView browser
      openBrowser();
   }
      
   // URL for the WebView
   private String getURL() {
      String url = "http://my.fit.edu/~pwelch2010/place-search.html";
	  return url;
	} 

   // Open WebView browser
   private void openBrowser() {
      webView.getSettings().setJavaScriptEnabled(true);
      webView.loadUrl(getURL());
   }
}