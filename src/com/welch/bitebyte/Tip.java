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
		billAmount = (EditText) findViewById(R.id.bill_text);
		billAmount.requestFocus();
		View tipCalculate = findViewById(R.id.tipCalculate);
	 	tipCalculate.setOnClickListener(this);
	} // end findViews method

	/** Calculate Tip and set textView with the answer **/
	private void calculateTip() {
		double answer = 0;
		double price = Double.parseDouble(billAmount.getText().toString());
		switch(getPercent(percentSpinner)){
		case 0:
			answer = roundAnswer((price * .10));
			answerAmount.setText(Double.toString(answer));
		break;
		case 1:
			answer = roundAnswer((price * .15));
			answerAmount.setText(Double.toString(answer));
		break;
		case 2:
			answer = roundAnswer((price * .20));
			answerAmount.setText(Double.toString(answer));
		break;
		case 3:
			answer = roundAnswer((price * .25));
			answerAmount.setText(Double.toString(answer));
		break;
		case 4:
			answer = roundAnswer((price * .30));
			answerAmount.setText(Double.toString(answer));
		break;
		} //end switch
	} // end calculateTip method
	
	/** Get the selected percent from the spinner **/
	private int getPercent(Spinner spinner){
		int index = spinner.getSelectedItemPosition();
		return index;
	} // end getPercent method
	
	/** Round double answer to 2 places **/
	public double roundAnswer(double d) {
	    return Math.round(d * Math.pow(10, (double) 2)) / Math.pow(10,
	            (double) 2);
	} // end roundAnswer method
	
	/** Spinner Listeners **/
	public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
		parent.getItemAtPosition(position);
	}
	public void onNothingSelected(AdapterView parent){
		// Do Nothing.
	}
	
	/** Sets the spinner and data for the spinner */
	private void setAdapters() {
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.percents, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    percentSpinner.setAdapter(adapter);
	    percentSpinner.setSelection(1); // Default to select element 1 from the spinner
	} // end setAdapters method
} // end Tip.java class/activity