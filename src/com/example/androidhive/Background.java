package com.example.androidhive;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;

public class Background extends Activity {
	String[] Theme = {" ANDROID ", "  FLOWER ", "   COLOR "};
    String[] Vibration = {"       NO ", "      YES "};
    ImageButton butt;
    Vibrator vibrator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_background);
		
		addListenerOnButton();
		
		AbsoluteLayout al = (AbsoluteLayout) findViewById(R.id.background);
		al.setBackgroundResource(R.drawable.andwall);
		
		Spinner s = (Spinner) findViewById(R.id.theme);
		
		ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Theme);
		a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(a);
		
        Spinner s2 = (Spinner) findViewById(R.id.sound);
		
		ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Vibration);
		a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s2.setAdapter(a2);
		
		s.setOnItemSelectedListener(new OnItemSelectedListener() {
	      public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {	
	    	  switch(pos) {
	    	    case 0:      	
	    	    	AbsoluteLayout ala = (AbsoluteLayout) findViewById(R.id.background);
	    	    	
	    			ala.setBackgroundResource(R.drawable.andwall); 		    	    	
	    	        break;
	    	    case 1:
	    	    	AbsoluteLayout alf = (AbsoluteLayout) findViewById(R.id.background);
	    			alf.setBackgroundResource(R.drawable.flower_3);	    	    		    	
	    	        break;
	    	    case 2:
	    	    	AbsoluteLayout alm = (AbsoluteLayout) findViewById(R.id.background);
                    Drawable d = getResources().getDrawable(R.drawable.home);
                    d.setAlpha(1000);
	    			alm.setBackgroundResource(R.drawable.home);
	    			break;
	    	  }
	      }
	      
	      public void onNothingSelected(AdapterView<?> parent) {
	  	  }
		});	
				
		s2.setOnItemSelectedListener(new OnItemSelectedListener() {
		      public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {	
		    	  switch(pos) {
		    	    case 0:      	
		    	        break;
		    	    case 1:	 
		    	    	vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);  
		    			long [] pattern = {100,400,100,400};   
		    			vibrator.vibrate(pattern, -1); 	
		    	        break;
		    	  }
		      }
		      
		      public void onNothingSelected(AdapterView<?> parent) {
		  	  }
			});	
	}

	public void addListenerOnButton() {

		butt = (ImageButton) findViewById(R.id.imageButton1);

		butt.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
	        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	startActivity(login);
	        	// Closing dashboard screen
	        	finish();
				Toast.makeText(Background.this,
						"Logout! Have a nice day!", Toast.LENGTH_SHORT).show();

			}

		});


}
}


