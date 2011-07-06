package com.welch.bitebyte;

/**
 * Program: Bite-Byte.java
 * @author: Paul Welch
 * Purpose: This program uses GPS coordinates from a Android device
 * and Google APIs to show the location of restaurants in the area of a user. 
 * This application was built to meet the requirements of CIS5080 - Summer 2011.
 */

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

/** Main class and first Activity class **/
public class BiteByte extends Activity implements View.OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /** Listeners for all buttons **/
        View findButton = findViewById(R.id.find_button);	// Set View for find_button (Find Restaurant)
        findButton.setOnClickListener(this);				// Set findButton (Find Restaurant) Listener
        View tipButton = findViewById(R.id.tip_button);		// Set View for tip_button (Tip Calculator)
        tipButton.setOnClickListener(this);					// Set tipButton (Tip Calculator) Listener
        View aboutButton = findViewById(R.id.about_button);	// Set View for about_button (About)
        aboutButton.setOnClickListener(this);				// Set aboutButton (About) Listener
        View exitButton = findViewById(R.id.exit_button);	// Set View for exit_button (Exit)
        exitButton.setOnClickListener(this);       			// Set exit_button (Exit) Listener
        } // end Main method
    
    /** OnClickListener method for button selection **/
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.find_button:	// Start webView if "Find Restaurant" is selected.
    		Intent a = new Intent(this, Browser.class);
    		startActivity(a);
    		break;
    	case R.id.tip_button:	// Start Tip Calculator if "Tip Calculator" is selected.
    		Intent t = new Intent(this, Tip.class);
    		startActivity(t);
    		break;
    	case R.id.about_button: // Open About Dialog if "About" is selected.
    		Intent i = new Intent(this, About.class);
    		startActivity(i);
    		break;
    	case R.id.exit_button:	// Exit application if "Exit" is selected.
    		finish();
    		break;
    	} // end switch  	
  	} // end onClick method
} // end Main BiteByte.java class/activity