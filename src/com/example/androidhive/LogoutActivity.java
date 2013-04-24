package com.example.androidhive;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class LogoutActivity extends Activity {

	ImageButton imageButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logout);

		addListenerOnButton();

	}

	public void addListenerOnButton() {

		imageButton = (ImageButton) findViewById(R.id.imageButton1);

		imageButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
	        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	startActivity(login);
	        	// Closing dashboard screen
	        	finish();
				Toast.makeText(LogoutActivity.this,
						"Logout! Have a nice day!", Toast.LENGTH_SHORT).show();

			}

		});
	
	}

}