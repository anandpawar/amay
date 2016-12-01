package com.domestic.services;





import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Home extends ActionBarActivity implements OnClickListener{

	private Button mcooking, mlaundry,melectrician, mplumber;



	private String category;
	 // flag for Internet connection status
    Boolean isInternetPresent = false;
     
    // Connection detector class
    ConnectionDetector cd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		AdView mAdView = (AdView) findViewById(R.id.adView);

		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		mcooking = (Button) findViewById(R.id.cooking);
		mlaundry = (Button) findViewById(R.id.laundry);
		melectrician = (Button) findViewById(R.id.electrician);
		mplumber = (Button) findViewById(R.id.plumber);

		mcooking.setOnClickListener(this);
		mlaundry.setOnClickListener(this);
		melectrician.setOnClickListener(this);
		mplumber.setOnClickListener(this);
		cd = new ConnectionDetector(getApplicationContext());
	}
	public void onClick(View v) {
		isInternetPresent = cd.isConnectingToInternet();
		 if (!isInternetPresent) {
	            // Internet Connection is Present
	            // make HTTP requests
	            showAlertDialog(Home.this, "Internet Error",
	                    "You dont have internet connection", true);
	        }else{
		Intent i = new Intent(this, Service.class);
		switch (v.getId()) {
		case R.id.plumber:
			category="plumber";
			break;

		case R.id.cooking:
			category="cook";
			break;

		case R.id.electrician:
			category="electrician";
			break;
		case R.id.laundry:
			category="laundry";
			break;

		default:
			break;

		}

		//Create the bundle
		Bundle bundle = new Bundle();
		bundle.putString("category", category);
		i.putExtras(bundle);
		startActivity(i);

	}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}
	  public void showAlertDialog(Context context, String title, String message, Boolean status) {
	        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
	 
	        // Setting Dialog Title
	        alertDialog.setTitle(title);
	 
	        // Setting Dialog Message
	        alertDialog.setMessage(message);
	         
	        // Setting alert dialog icon
	        alertDialog.setIcon((status) ? R.drawable.ic_launcher : R.drawable.ic_launcher);
	 
	        // Setting OK Button
	        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            }
	        });
	 
	        // Showing Alert Message
	        alertDialog.show();
	    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings://rate us implicit intent add
            Uri uri = Uri.parse("market://details?id=com.domestic.services" );
            	Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            	try {
            	  startActivity(goToMarket);
            	} catch (ActivityNotFoundException e) {
            	  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.domestic.services")));
            	}
            	//Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.adg.dddate"));
            	//startActivity(intent);
            	return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    

		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, s
		// as you specify a parent activity in AndroidManifest.xml.
/*		int id = item.getItemId();
		if (id == R.id.action_settings) {
			
			 Uri marketUri = Uri.parse("www.google.com" );
			 Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
			 startActivity(marketIntent);
			
			return true;
		}*/
	//	return super.onOptionsItemSelected(item);
	}



}
