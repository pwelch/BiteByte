package com.welch.bitebyte;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class BiteByte extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        
        // Set up listeners for all the buttons
        // Move to method later?
        
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);       
        }
    
    // Method used by OnClickListener for button selection
    public void onClick(View v) {
    	switch (v.getId()) {
    	
    	case R.id.about_button:
    		Intent a = new Intent(this, About.class);
    		startActivity(a);
    		break;
    	case R.id.exit_button:
    		finish();
    		break;
    		// More buttons here
    	}
    }
}