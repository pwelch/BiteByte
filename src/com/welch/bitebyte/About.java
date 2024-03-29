package com.welch.bitebyte;

/**
 * Program: About.java
 * @author: Paul Welch
 * This activity is for the About Activity which displays the program information.
 */

import android.app.Activity;
import android.os.Bundle;

/** About Activity to display the About this Program information */
public class About extends Activity {
	/* The main method for every activity. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		/* This activity is called for the about message.
		 * See strings.xml for About text. 
		 */
	} // end main method for About Activity
} // end About.java Activity