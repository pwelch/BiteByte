package com.welch.bitebyte;

/**
 * Program: Tip.java
 * @author: Paul Welch
 * This activity is a Tip Calculator
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/** Activity for Tip Calculator **/
public class Tip extends Activity implements View.OnClickListener, OnItemSelectedListener {
	/** Set class variables **/
	private Spinner percentSpinner;
	private TextView answerAmount;
	private TextView totalAmount;
	private EditText billAmount;

	/** The main for activity. **/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tip);
	      findViews(); 		// Set views and listeners on activity start.
	      setAdapters();	// Set spinner adapter on activity start.
	} // end main method
	
	/** Tip Calculator Button **/
	public void onClick(View v) {
		// Try/catch block to catch errors thrown by empty field when "Calculate Tip" is clicked
		try {
 	        	calculateTip(); // Execute if no errors thrown
	        } 
				catch (Exception e) 
				{
				   // If error generated by blank "Bill Amount Field" 
			       Toast toast = Toast.makeText(this, "Please Enter Bill Amount", Toast.LENGTH_LONG);
			       toast.show();
			    }
	} // end onClick method
	
	/** Set Views and Listeners **/
	private void findViews() {
		// Set percentSpinner View (Percent Drop Down)
		percentSpinner = (Spinner) findViewById(R.id.tip_rate);
		// Set percentSpinner Listener (Percent Drop Down)
		percentSpinner.setOnItemSelectedListener(this);
		// Set answerAmount View (Tip Amount)	
		answerAmount = (TextView) findViewById(R.id.answerAmount_text);
		// Set totalAmount View (Tip Amount)
		totalAmount = (TextView) findViewById(R.id.totalAmount_text);
		// set billAmount View (Total Amount)
		billAmount = (EditText) findViewById(R.id.bill_text);
		// Set focus on billAmount EditText field (Bill Amount)
		billAmount.requestFocus();							
		// Set tipCalculate View (Calculate Tip Button)
		View tipCalculate = findViewById(R.id.tipCalculate);
		// Set tipCalulate Button Listener (Calculate Tip Button)
	 	tipCalculate.setOnClickListener(this);								
	} // end findViews method
   
	/** Calculate Tip **/
	private void calculateTip() {
	   // Tip Total variable
	   double total = 0;
	   // Total bill amount variable
	   double answer = 0;
	   // Get price from billAmount (Bill Amount Field) and parse to double 
	   double price = Double.parseDouble(billAmount.getText().toString());
	   // Get percent from percentSpinner (Percent Drop Down) and parse to double
	   double percentage  =  Double.parseDouble(percentSpinner.getSelectedItem().toString());
	   // Change the selected item from the spinner to a decimal percent. Example: 10 /100 = .10
	   percentage = (percentage / 100 );
	   // Calculate tip and round to two decimal places
	   answer = roundAnswer((price * percentage));
	   // Set answer textView (Tip Amount)
	   answerAmount.setText(Double.toString(answer));
	   // Calculate total bill amount
	   total = price + answer;
	   // Set total textView (Total Amount)
	   totalAmount.setText(Double.toString(total));												
   } // end calculateTip method
		
	/** Round the Tip Total which is a double to 2 places. 
	    This needs to be replaced with a more accurate way to display two decimal places.	
	**/
	private double roundAnswer(double answer) {
	    return Math.round(answer * Math.pow(10, (double) 2)) / Math.pow(10,(double) 2);
	} // end roundAnswer method
	
	/** Spinner Listeners. Referenced from Android API **/
	public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
		parent.getItemAtPosition(position);
	}
	public void onNothingSelected(AdapterView parent){
		// Do Nothing if spinner not selected.
	} // end Spinner Listeners
	
	/** Sets the spinner and data for the spinner. Referenced from Android API */
	private void setAdapters() {
		// Set the type of spinner and the data resources for it
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.percents, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    percentSpinner.setAdapter(adapter);
	 	// Default to select element 1 from the spinner
	    percentSpinner.setSelection(1); 
	} // end setAdapters method
} // end Tip.java class/activity