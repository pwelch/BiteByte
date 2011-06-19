package com.welch.bitebyte;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/** WebView Activity to display Places/Map */
public class Browser extends Activity implements LocationListener {
	private WebView webView; 				// Create WebView object
	private Location mostRecentLocation;	// Create Location object
	private LocationManager locationManager; 
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.browser);
      getLocation();	// Get the current location
      openBrowser();	// Open a browser with the Google MapView  
   } // end Main Browser.java Activity method
   
   /** Called when Activity Resumes **/
   @Override
   protected void onResume() {
	   super.onResume();
	   getLocation();
   } // end onResume method
   
   /** Called when Activity is Paused **/
   @Override
   protected void onPause() {
	   super.onPause();
	   locationManager.removeUpdates(this);
   } // end onPause method
   
   /** Create webView and JavaScript Interface **/
   private void openBrowser(){
 	  webView = (WebView) findViewById(R.id.web_view);		// Create webview and assign to web_view item
 	  webView.getSettings().setJavaScriptEnabled(true);		// JavaScript is off by default, enabling JavaScript
 	  webView.setWebViewClient(new WebViewClient());		// Create and set WebViewClient subclass for rendering
 	  webView.loadUrl(getURL());							// Load bite.html page with webView
 	  
 	  // Add Java to JavaScript Interface and call it 'android' for access.
 	  webView.addJavascriptInterface(new JavaScriptInterface(), "android");
   } // end Browser method
      
   // Method to set/return URL for map page source
   private String getURL() {
      final String url = "http://my.fit.edu/~pwelch2010/bite.html";
	  return url;
	} // end getURL method

   /** Retrieve current coordinates from GPS
    *  To save battery on the device the location update time has been increased. **/
   private void getLocation() {
	     locationManager =
	      (LocationManager)getSystemService(Context.LOCATION_SERVICE);	// Android GPS Manager
	    Criteria criteria = new Criteria();								// Application criteria for selection location provider
	    criteria.setAccuracy(Criteria.ACCURACY_FINE);					// Set the accuracy requirement
	    String provider = locationManager.getBestProvider(criteria,true); 	// Get location data from best source
	    locationManager.requestLocationUpdates(provider, 15000, 1, this); 	// Get updates of current location
	    mostRecentLocation = locationManager.getLastKnownLocation(provider);
   } // end getLocation method
   
   /** Get the current Latitude and Longitude **/
   private class JavaScriptInterface {
	   public double getLatitude(){
	     return mostRecentLocation.getLatitude();
	   }
	   public double getLongitude(){
	     return mostRecentLocation.getLongitude();
	   }
	 } // end JavaScriptInterface method
   
   /** Required methods when using LocationListener 
    *  Referenced from Android API				**/ 
   @Override
   public void onProviderDisabled(String provider) {
   }
   @Override
   public void onProviderEnabled(String provider) {
   }
   @Override
   public void onStatusChanged(String provider, int status, Bundle extras) {
   }
   @Override
   public void onLocationChanged(Location location) {
	   mostRecentLocation = location;
   }
   /** End required methods when using LocationListener **/
   
} // End Browser.class Activity