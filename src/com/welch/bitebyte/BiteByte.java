package com.welch.bitebyte;

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
        View goButton = findViewById(R.id.go_button);
        goButton.setOnClickListener(this);
        View tipButton = findViewById(R.id.tip_button);
        tipButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);       
        } // end Main method
    
    /** OnClickListener method for button selection **/
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.go_button:
    		Intent a = new Intent(this, Browser.class);
    		startActivity(a);
    		break;
    	case R.id.tip_button:
    		Intent t = new Intent(this, Tip.class);
    		startActivity(t);
    		break;
    	case R.id.about_button:
    		Intent i = new Intent(this, About.class);
    		startActivity(i);
    		break;
    	case R.id.exit_button:
    		finish();
    		break;
    	} // end switch  	
  	} // end onClick method
} // end Main BiteByte.java class/activity