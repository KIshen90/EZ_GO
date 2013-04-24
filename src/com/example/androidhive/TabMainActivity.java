package com.example.androidhive;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabMainActivity extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_main);

		Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
		
		// Android tab
		Intent intentAndroid = new Intent().setClass(this, SearchActivity.class);
		TabSpec tabSpecAndroid = tabHost
			.newTabSpec("Android")
			.setIndicator("", ressources.getDrawable(R.drawable.picture0))
			.setContent(intentAndroid);

		// Apple tab
		Intent intentApple = new Intent().setClass(this, GoogleMapActivity.class);
		TabSpec tabSpecApple = tabHost
			.newTabSpec("Apple")
			.setIndicator("", ressources.getDrawable(R.drawable.picture1))
			.setContent(intentApple);
		
		// Windows tab
		Intent intentWindows = new Intent().setClass(this, CreditsActivity.class);
		TabSpec tabSpecWindows = tabHost
			.newTabSpec("Windows")
			.setIndicator("", ressources.getDrawable(R.drawable.picture2))
			.setContent(intentWindows);
		
		// Blackberry tab
		Intent intentBerry = new Intent().setClass(this, LogoutActivity.class);
		TabSpec tabSpecBerry = tabHost
			.newTabSpec("Berry")
			.setIndicator("", ressources.getDrawable(R.drawable.picture3))
			.setContent(intentBerry);
	
		// add all tabs 
		tabHost.addTab(tabSpecAndroid);
		tabHost.addTab(tabSpecApple);
		tabHost.addTab(tabSpecWindows);
		tabHost.addTab(tabSpecBerry);
		
		//set Windows tab as default (zero based)
		tabHost.setCurrentTab(0);
	}

}