package com.domestic.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;



public class Service extends ActionBarActivity {

	String category;
	// Progress Dialog
	private ProgressDialog pDialog;
	ListAdapter adapter;

	// php read comments script

	// localhost :
	// testing on your device
	// put your local ip instead, on windows, run CMD > ipconfig
	// or in mac's terminal type ifconfig and look for the ip under en0 or en1
	// private static final String READ_COMMENTS_URL =
	// "http://xxx.xxx.x.x:1234/webservice/comments.php";

	// testing on Emulator:
	private static final String READ_COMMENTS_URL = "http://utopiansolutions.co.in/at/domestic/readservice.php";

	// testing from a real server:
	// private static final String READ_COMMENTS_URL =
	// "http://www.mybringback.com/webservice/comments.php";

	// JSON IDS:
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_MESSAGE = "message";
	private static final String TAG_CATEGORY = "category";
	private static final String TAG_USERNAME = "name";
	private static final String TAG_SERVICE = "posts";
	private static final String TAG_USERID = "id";
	private static final String TAG_ADDRESS = "address";
	private static final String TAG_CONTACT_NO = "contact_no";
	// it's important to note that the message is both in the parent branch of
	// our JSON tree that displays a "Post Available" or a "No Post Available"
	// message,
	// and there is also a message for each individual post, listed under the
	// "posts"
	// category, that displays what the user typed as their message.

	// An array of all of our comments
	private JSONArray mService = null;
	Button call ;
	ListView lv;
	// manages all of our comments in a list.
	private ArrayList<HashMap<String, String>> mServiceList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// note that use read_comments.xml instead of our single_post.xml
		setContentView(R.layout.service);
		AdView mAdView = (AdView) findViewById(R.id.adView);

		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		category = getIntent().getStringExtra("category");
		TextView text3 = (TextView) findViewById(R.id.category);
		String cat=null; 
		if(category.equals("plumber"))
			cat="PLUMBER LIST";
		else if(category.equals("cook"))
			cat="CLEANING LIST";
		else if(category.equals("electrician"))
			cat="ELECTRICIAN LIST";
		else if(category.equals("laundry"))
			cat="LAUNDRY LIST";
        text3.setText(cat);
		lv =(ListView)findViewById(R.id.list);

	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// loading the comments via AsyncTask
		new LoadService().execute();
	}


	/**
	 * Retrieves recent post data from the server.
	 */
	public String updateJSONdata() {

		// Instantiate the arraylist to contain all the JSON data.
		// we are going to use a bunch of key-value pairs, referring
		// to the json element name, and the content, for example,
		// message it the tag, and "I'm awesome" as the content..



		mServiceList = new ArrayList<HashMap<String, String>>();

		// Bro, it's time to power up the J parser
		JSONParser jParser = new JSONParser();
		// Feed the beast our comments url, and it spits us
		// back a JSON object. Boo-yeah Jerome.
		try{
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("category", category));

			Log.d("request!", "starting");
			JSONObject json = jParser.makeHttpRequest(READ_COMMENTS_URL, "POST",
					params);
			Log.d("Login attempt", json.toString());
			int success = json.getInt(TAG_SUCCESS);
			if(success==0){
				Log.d("Login Failure!", json.getString(TAG_MESSAGE));
				return json.getString(TAG_MESSAGE);

			}else{
				// when parsing JSON stuff, we should probably
				// try to catch any exceptions:

				// I know I said we would check if "Posts were Avail." (success==1)
				// before we tried to read the individual posts, but I lied...
				// mComments will tell us how many "posts" or comments are
				// available
				mService = json.getJSONArray(TAG_SERVICE);

				// looping through all posts according to the json object returned
				for (int i = 0; i < mService.length(); i++) {
					JSONObject c = mService.getJSONObject(i);

					// gets the content of each tag
					String username = c.getString(TAG_USERNAME);
					String address = c.getString(TAG_ADDRESS);
					String contact_no = c.getString(TAG_CONTACT_NO);
					String category = c.getString(TAG_CATEGORY);
					String id = c.getString(TAG_USERID);


					// creating new HashMap
					HashMap<String, String> map = new HashMap<String, String>();

					map.put(TAG_USERNAME, username);
					map.put(TAG_ADDRESS, address);
					map.put(TAG_CONTACT_NO, contact_no);
					//	map.put(TAG_USERNAME, category);

					// adding HashList to ArrayList
					mServiceList.add(map);

					// annndddd, our JSON data is up to date same with our array
					// list
				}

			}	return json.getString(TAG_MESSAGE);} catch (JSONException e) {
				e.printStackTrace();
			}
		return category;
	}

	/**
	 * Inserts the parsed data into the listview.
	 */
	private void updateList() {
		// For a ListActivity we need to set the List Adapter, and in order to do
		//that, we need to create a ListAdapter.  This SimpleAdapter,
		//will utilize our updated Hashmapped ArrayList, 
		//use our single_post xml template for each item in our list,
		//and place the appropriate info from the list to the
		//correct GUI id.  Order is important here.
		/*ListAdapter adapter = new SimpleAdapter(this, mServiceList,
				R.layout.single_post, new String[] { TAG_USERNAME, TAG_ADDRESS,
						TAG_CONTACT_NO }, new int[] { R.id.username, R.id.address,
						 });

		// I shouldn't have to comment on this one:
		setListAdapter(adapter);

		// Optional: when the user clicks a list item we 
		//could do something.  However, we will choose
		//to do nothing...
		ListView lv = getListView();	*/
		adapter = new LazyAdapter(Service.this, mServiceList);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// This method is triggered if an item is click within our
				// list. For our example we won't be using this, but
				// it is useful to know in real life applications.
				String contact_no = ((TextView) view.findViewById(R.id.contact_no)).getText().toString();
				//Toast.makeText(Service.this, contact_no , Toast.LENGTH_LONG).show();
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact_no));
				startActivity(intent);
				finish();

			}
		});
	}

	public class LoadService extends AsyncTask<Void, Void, Boolean> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(Service.this);
			pDialog.setMessage("Loading Service...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected Boolean doInBackground(Void... arg0) {
			updateJSONdata();
			return null;

		}

		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			pDialog.dismiss();
			updateList();
		}
	}
}

