package com.domestic.services;





import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity implements OnClickListener {
	private EditText firstname, lastname,email_1,mob_no,address_1,password,confirm_password;
	private Button  mRegister;
	private ProgressDialog pDialog;
	 // JSON parser class
    JSONParser jsonParser = new JSONParser();
    
    //php register script
    
    //localhost :  
    //testing on your device
    //put your local ip instead,  on windows, run CMD > ipconfig
    //or in mac's terminal type ifconfig and look for the ip under en0 or en1
   // private static final String REGISTER_URL = "http://xxx.xxx.x.x:1234/webservice/register.php";
    
    //testing on Emulator:
    private static final String REGISTER_URL = "http://utopiansolutions.co.in/at/domestic/register.php";
    
  //testing from a real server:
    //private static final String REGISTER_URL = "http://www.mybringback.com/webservice/register.php";
    
    //ids
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		firstname = (EditText)findViewById(R.id.firstname);
		lastname = (EditText)findViewById(R.id.lastname);
		email_1 = (EditText)findViewById(R.id.email);
		address_1 = (EditText)findViewById(R.id.address);
		mob_no = (EditText)findViewById(R.id.mob_no);
		password = (EditText)findViewById(R.id.password);
		confirm_password = (EditText)findViewById(R.id.confirm_password);

		mRegister = (Button)findViewById(R.id.mregister);
		mRegister.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
				new CreateUser().execute();
		
	}
	
	class CreateUser extends AsyncTask<String, String, String> {

		
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Register.this);
            pDialog.setMessage("Creating User...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
		
		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			 // Check for success tag
            int success;
            String fname = firstname.getText().toString();
            String lname = lastname.getText().toString();
            String address = address_1.getText().toString();

            String mobile_no = mob_no.getText().toString();

            String email = email_1.getText().toString();

            String pass = password.getText().toString();

            String conf_pass = confirm_password.getText().toString();

            
            try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("fname", fname));
                params.add(new BasicNameValuePair("lname", lname));
                params.add(new BasicNameValuePair("add", address));
                params.add(new BasicNameValuePair("mob", mobile_no));
                params.add(new BasicNameValuePair("username", email));
                params.add(new BasicNameValuePair("password", pass)); 
                
                
 
                Log.d("request!", "starting");
                
                //Posting user data to script 
                JSONObject json = jsonParser.makeHttpRequest(
                       REGISTER_URL, "POST", params);
 
                // full json response
                Log.d("Registering attempt", json.toString());
 
                // json success element
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                	Log.d("User Created!", json.toString());              	
                	finish();
                	return json.getString(TAG_MESSAGE);
                }else{
                	Log.d("Registering Failure!", json.getString(TAG_MESSAGE));
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
            if (file_url != null){
            	Toast.makeText(Register.this, file_url, Toast.LENGTH_LONG).show();
            }
 
        }
		
	}
		 

}
