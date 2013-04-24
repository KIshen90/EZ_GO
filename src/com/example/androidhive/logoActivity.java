package com.example.androidhive;

import com.example.androidhive.LoginActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Vibrator;

public class LogoActivity extends Activity {
    ImageButton ib;
    private Vibrator vibrator;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logo);
		addListenerOnButton();
		

		vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);  
		long [] pattern = {100,400,100,400};   // 停止 开启 停止 开启   
		vibrator.vibrate(pattern,-1);           //重复两次上面的pattern 如果只想震动一次，index设为-1  
		
	}
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

	public void addListenerOnButton() {

		final Context context = this;

		ib = (ImageButton) findViewById(R.id.imageView2);

		ib.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

			    Intent intent = new Intent(context, LoginActivity.class);
	                        startActivity(intent);   

			}

		});

	}
	
 
	public void onStop(){  
		super.onStop();  
		vibrator.cancel();  
		}  
	
}






