package com.domestic.services;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ContactUs extends ActionBarActivity implements OnClickListener{
	private TextView tv,call1,call2;
	String c1,c2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contactus);
		AdView mAdView = (AdView) findViewById(R.id.adView);

		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);

		tv = (TextView) findViewById(R.id.textView1);
		call1 = (TextView) findViewById(R.id.textView5);
		call2 = (TextView) findViewById(R.id.textView6);
		 c1 = ((TextView) findViewById(R.id.textView5)).getText().toString();
		 c2 = ((TextView) findViewById(R.id.textView6)).getText().toString();
		tv.setOnClickListener(ContactUs.this);
		
		call1.setOnClickListener(ContactUs.this);
		call2.setOnClickListener(ContactUs.this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
	/*	int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
		*/
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

	

	@Override
	public void onClick(View v) {
		
		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		case R.id.textView1:

				Intent i2 = new Intent(this, Login.class);
				startActivity(i2);
			    break;
		case R.id.textView5:
			

			
			
			//Toast.makeText(Service.this, contact_no , Toast.LENGTH_LONG).show();
			Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + c1));
			startActivity(intent);
			
			break;
		case R.id.textView6:

		
			
			//Toast.makeText(Service.this, contact_no , Toast.LENGTH_LONG).show();
			Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + c2));
			startActivity(intent1);
			
			break;
		
			
			

		default:
			break;
		}
		
	//	Intent i2 = new Intent(this, Login.class);
	//	startActivity(i2);
		
	}
}
