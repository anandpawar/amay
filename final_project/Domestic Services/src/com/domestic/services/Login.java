package com.domestic.services;





import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pushbots.push.Pushbots;

public class Login extends ActionBarActivity implements OnClickListener {

	private EditText user, pass;
	private Button mSubmit, mRegister,mguestlogin;
	private TextView textView1;
	 // flag for Internet connection status
    Boolean isInternetPresent = false;
     
    // Connection detector class
    ConnectionDetector cd;

	// Progress Dialog
	private ProgressDialog pDialog;

	// JSON parser class
	JSONParser jsonParser = new JSONParser();
	

	// php login script location:

	// localhost :
	// testing on your device
	// put your local ip instead, on windows, run CMD > ipconfig
	// or in mac's terminal type ifconfig and look for the ip under en0 or en1
	// private static final String LOGIN_URL =
	// "http://xxx.xxx.x.x:1234/webservice/login.php";

	// testing on Emulator:
	private static final String LOGIN_URL = "http://utopiansolutions.co.in/at/domestic/login.php";

	// testing from a real server:
	// private static final String LOGIN_URL =
	// "http://www.mybringback.com/webservice/login.php";

	// JSON element ids from repsonse of php script:
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_MESSAGE = "message";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	    Pushbots.sharedInstance().init(this);


		user = (EditText) findViewById(R.id.username);
		pass = (EditText) findViewById(R.id.password);

		mSubmit = (Button) findViewById(R.id.login);
		mRegister = (Button) findViewById(R.id.register);
		mguestlogin = (Button) findViewById(R.id.guestlogin);
		textView1 = (TextView) findViewById(R.id.textView1);
        
		// register listeners
		mSubmit.setOnClickListener(Login.this);
		mRegister.setOnClickListener(Login.this);
		mguestlogin.setOnClickListener(Login.this);
		 cd = new ConnectionDetector(getApplicationContext());
		 
		    textView1.setOnClickListener(Login.this);

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		isInternetPresent = cd.isConnectingToInternet();
		 
        // check for Internet status
        if (!isInternetPresent) {
            // Internet Connection is Present
            // make HTTP requests
            showAlertDialog(Login.this, "Internet Connection",
                    "You dont have internet connection", true);
        } else{
		switch (v.getId()) {
		case R.id.login:
			new AttemptLogin().execute();
			break;
		case R.id.register:
			Intent i = new Intent(this, Register.class);
			startActivity(i);
			break;
		case R.id.guestlogin:
			Intent i1 = new Intent(this, Home.class);
			startActivity(i1);
			break;
		case R.id.textView1:
			Intent i2 = new Intent(this, ContactUs.class);
			startActivity(i2);
			break;
			
			

		default:
			break;
		}
	}
        
        
	}
	
	class AttemptLogin extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(Login.this);
			pDialog.setMessage("Attempting login...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			// Check for success tag
			int success;
			String username = user.getText().toString();
			String password = pass.getText().toString();
			try {
				// Building Parameters
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("username", username));
				params.add(new BasicNameValuePair("password", password));

				Log.d("request!", "starting");
				// getting product details by making HTTP request
				JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST",
						params);

				// check your log for json response
				Log.d("Login attempt", json.toString());

				// json success tag
				success = json.getInt(TAG_SUCCESS);
				if (success == 1) {
					Log.d("Login Successful!", json.toString());
					// save user data
					SharedPreferences sp = PreferenceManager
							.getDefaultSharedPreferences(Login.this);
					Editor edit = sp.edit();
					edit.putString("username", username);
					edit.commit();

					Intent i = new Intent(Login.this, Home.class);
					finish();
					startActivity(i);
					return json.getString(TAG_MESSAGE);
				} else {
					Log.d("Login Failure!", json.getString(TAG_MESSAGE));
					return json.getString(TAG_MESSAGE);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;

		}
		@Override
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once product deleted
			pDialog.dismiss();
			if (file_url != null) {
				Toast.makeText(Login.this, file_url, Toast.LENGTH_LONG).show();
			}

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
	/*	int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
		
	}*/

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
