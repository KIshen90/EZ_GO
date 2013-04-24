package com.example.androidhive;

import java.util.Calendar;

import com.example.androidhive.library.UserFunctions;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Button;
//import android.view.View;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
//import android.widget.AdapterView;

public class SearchActivity extends Activity {
	String[] tripType = {" ONE-WAY TRIP ", "   ROUND TRIP  "};
	UserFunctions userFunctions;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		
		Spinner s = (Spinner) findViewById(R.id.widget40_copy);
		ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tripType);
		a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(a);
		
		AutoCompleteTextView t = (AutoCompleteTextView) findViewById(R.id.widget37);
		String[] p = getResources().getStringArray(R.array.places);
		ArrayAdapter<String> a2 = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, p);
	    t.setAdapter(a2);    
	    
	    AutoCompleteTextView t2 = (AutoCompleteTextView) findViewById(R.id.widget39);
		String[] p2 = getResources().getStringArray(R.array.places);
		ArrayAdapter<String> a3 = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, p2);
	    t2.setAdapter(a3);
	    
	    
	}	
	
	@SuppressLint("NewApi")
	public void showStartDatePickerDialog(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getFragmentManager(), "StartDate");
	}
	
	@SuppressLint("NewApi")
	public void showEndDatePickerDialog(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getFragmentManager(), "EndDate");
	}
	
	@SuppressLint({ "ValidFragment", "NewApi" })
	public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

		@SuppressLint("NewApi")
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view,int yy , int mm , int dd){
			// Do something with the date chosen by the user
			
			StringBuilder sb = new StringBuilder();
			
			 sb.append(mm + 1);
		     sb.append("/");
		     sb.append(dd);
		     sb.append("/");
		     sb.append(yy);
		     String x = sb.toString();
		     
		      if (getTag()=="StartDate") {
		    	  Button startButton = (Button) findViewById(R.id.widget40);
		    	  startButton.setText(x);		
	          }
	     
		      if (getTag()=="EndDate") {
		    	  Button startButton = (Button) findViewById(R.id.widget41);
			      startButton.setText(x);		
		      }		
		}
	}
}
