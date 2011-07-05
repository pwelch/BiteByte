package com.welch.bitebyte;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;

/** Activity for Tip Calculator **/
public class Tip extends Activity implements View.OnClickListener, OnItemSelectedListener {
	/** Set class variables **/
	private Spinner percentSpinner;
	private TextView answerAmount;
	private TextView totalAmount;
	private EditText billAmount;

	/* The main for every activity. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tip);
	      findViews(); 		// Set views and listeners on activity start.
	      setAdapters();	// Set spinner adapter on activity start.
	} // end main method
	
	/** Tip Calculator Button **/
	public void onClick(View v) {
		    calculateTip();
	} // end onClick method
	
	/** Set Views and Listeners **/
	private void findViews() {
		percentSpinner = (Spinner) findViewById(R.id.tip_rate);
		percentSpinner.setOnItemSelectedListener(this);
		answerAmount = (TextView) findViewById(R.id.answerAmount_text);
		totalAmount = (TextView) findViewById(R.id.totalAmount_text);
		billAmount = (EditText) findViewById(R.id.bill_text);
		billAmount.requestFocus();
		View tipCalculate = findViewById(R.id.tipCalculate);
	 	tipCalculate.setOnClickListener(this);
	} // end findViews method
   
	/** Calculate Tip **/
	private void calculateTip() {
	   double total = 0;
	   double answer = 0;
	   double price = Double.parseDouble(billAmount.getText().toString());						// Get price from billAmount
	   double percentage  =  Double.parseDouble(percentSpinner.getSelectedItem().toString());	// Get percent from percentSpinner
	   percentage = (percentage / 100 );														// Get the percent value
	   answer = roundAnswer((price * percentage));												// Calculate tip
	   answerAmount.setText(Double.toString(answer));											// Set answer textView
	   total = price + answer;																	// Calculate total
	   totalAmount.setText(Double.toString(total));												// Set total textView
   } // end calculateTip method
		
	/** Round double answer to 2 places **/
	public double roundAnswer(double d) {
	    return Math.round(d * Math.pow(10, (double) 2)) / Math.pow(10,
	            (double) 2);
	} // end roundAnswer method
	
	/** Spinner Listeners. Reference from Android API**/
	public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
		parent.getItemAtPosition(position);
	}
	public void onNothingSelected(AdapterView parent){
		// Do Nothing.
	}
	
	/** Sets the spinner and data for the spinner. Referenced from Android API */
	private void setAdapters() {
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.percents, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    percentSpinner.setAdapter(adapter);
	    percentSpinner.setSelection(1); // Default to select element 1 from the spinner
	} // end setAdapters method
} // end Tip.java class/activity