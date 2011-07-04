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

public class Tip extends Activity implements View.OnClickListener, OnItemSelectedListener {
	private Spinner percentSpinner;
	private TextView amountAnswer;
	private EditText billAmount;

	/* The main for every activity. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tip);
	      findViews(); 
	      setAdapters();    
	} // end main method
	
	/** Listener for Tip Calculator Button **/
	public void onClick(View v) {
		 View tipCalculate = findViewById(R.id.tipCalculate);
		 	tipCalculate.setOnClickListener(this);
		    findTip();
	} // end onClick method
	
	/** Set views **/
	public void findViews() {
		percentSpinner = (Spinner) findViewById(R.id.tip_rate);
		percentSpinner.setOnItemSelectedListener(this);
		amountAnswer = (TextView) findViewById(R.id.amountAnswer_text);
		billAmount = (EditText) findViewById(R.id.bill_text);
		billAmount.requestFocus();
	} // end findViews method
	
	/** Spinner Listener POSSIBLE PROBLEM?? **/
	public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
		parent.getItemAtPosition(position);
	}
	public void onNothingSelected(AdapterView parent){
		// Do Nothing.
	}
	/** LISTENERS **/
	
	/** Calculate Tip and set textView with answer **/
	public void findTip() {
		double answer = 0;
		double price = Double.parseDouble(billAmount.getText().toString());
		switch(getPercent(percentSpinner)){
		case 0:
			answer = price * .10;
			amountAnswer.setText(Double.toString(answer));
		break;
		case 1:
			answer = price * .15;
			amountAnswer.setText(Double.toString(answer));
		break;
		case 2:
			answer = price * .20;
			amountAnswer.setText(Double.toString(answer));
		break;
		case 3:
			answer = price * .25;
			amountAnswer.setText(Double.toString(answer));
		break;
		case 4:
		answer = price * .30;
			amountAnswer.setText(Double.toString(answer));
		break;
		}
	} // end findTip method
	
	 /** Define data source for the spinners */
	   public void setAdapters() {
		  percentSpinner = (Spinner) findViewById(R.id.tip_rate);
	      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.percents, android.R.layout.simple_spinner_item);
	      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	      percentSpinner.setAdapter(adapter);
	      // Automatically select spinner item
	      percentSpinner.setSelection(1); // 

	   } // end setAdapters method
	
	   
	public int getPercent(Spinner spinner){
		//String percent = spinner.getSelectedItem().toString(); 
		
		int index = spinner.getSelectedItemPosition();
		///int lparen = percent.indexOf('('); 
		//int rparen = percent.indexOf(')'); 
		//percent = percent.substring(lparen + 1, rparen); 
		return index;
	}

} // end Tip class
