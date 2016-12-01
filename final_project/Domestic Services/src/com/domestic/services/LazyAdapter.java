package com.domestic.services;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class LazyAdapter extends BaseAdapter {
	
	Context context;

	private ArrayList<HashMap<String, String>> data;
	private static LayoutInflater inflater = null;
	HashMap<String, String> shop = new HashMap<String, String>();

public LazyAdapter(Context context)
{
this.context= context;	
}

	public LazyAdapter(Context context, ArrayList<HashMap<String, String>> d) {
		this.context = context;

		data = d;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//imageLoader = new ImageLoader(context.getApplicationContext());
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return data.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.single_post, null);
		
		
		
		TextView username = (TextView) vi.findViewById(R.id.username); // artist
		// name
		
		TextView address = (TextView) vi.findViewById(R.id.address);
		TextView contact_no = (TextView) vi.findViewById(R.id.contact_no);

		
		

		
		
		
		
		
		// duration
		/*ImageView thumb_image = (ImageView) vi.findViewById(R.id.list_image); // thumb
																				// image
		RatingBar rb = (RatingBar) vi.findViewById(R.id.ratingBar1);

		/***
		 * Offer image task reaining
		 ***/
		/*	ImageView offer_image = (ImageView) vi.findViewById(R.id.offer);
		ImageView floor_image = (ImageView) vi.findViewById(R.id.floor_image);

		/****
		 * Hidden fields in view
		 * 
		 ****/
		/*	TextView imageURL = (TextView) vi.findViewById(R.id.hidden_imageurl);
		TextView desc = (TextView) vi.findViewById(R.id.hidden_desc);
		TextView id = (TextView) vi.findViewById(R.id.hidden_id);
		TextView contact_no = (TextView) vi.findViewById(R.id.hidden_contact);
		TextView email = (TextView) vi.findViewById(R.id.hidden_email);
		TextView offers = (TextView) vi.findViewById(R.id.hidden_offers);
		TextView brand = (TextView) vi.findViewById(R.id.hidden_brands);
		TextView shop_fb = (TextView) vi.findViewById(R.id.hidden_fb);
		TextView shop_twitter = (TextView) vi.findViewById(R.id.hidden_twitter);
		TextView shop_gplus = (TextView) vi.findViewById(R.id.hidden_gplus);
		 */
		
		shop = data.get(position);
		

		username.setText(shop.get("name"));
		
		address.setText(shop.get("address"));
		

		contact_no.setText(shop.get("contact_no"));
	/*	
		call.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context, ""+shop.get("contact_no") , Toast.LENGTH_LONG).show();
				
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + shop.get("contact_no")));
				context.startActivity(intent);
				
			}
		});
*/
	
		
		
		/*imageURL.setText(shop.get(Search.THUMB_URL));

		imageLoader.DisplayImage(shop.get(Search.THUMB_URL), thumb_image);
		String RATING = shop.get(Search.RATING);
		rb.setRating(Float.parseFloat(RATING));

		// imageURL.setText(Search.THUMB_URL);
		id.setText(shop.get(Search.ID));
		contact_no.setText(shop.get(Search.CONTACT));
		email.setText(shop.get(Search.EMAIL));
		offers.setText(shop.get(Search.OFFERS));
		brand.setText(shop.get(Search.BRAND));
		shop_fb.setText(shop.get(Search.FB));
		shop_twitter.setText(shop.get(Search.TWITTER));
		shop_gplus.setText(shop.get(Search.GPLUS));

		if (shop.get(Search.SHOP_NO).equalsIgnoreCase("null")) {
			shop_no.setVisibility(View.INVISIBLE);
			vi.findViewById(R.id.text_shop_no).setVisibility(View.INVISIBLE);
		} else {
			shop_no.setVisibility(View.VISIBLE);
			vi.findViewById(R.id.text_shop_no).setVisibility(View.VISIBLE);
		}
		if (shop.get(Search.FLOOR).equalsIgnoreCase("null")) {

			floor.setVisibility(View.INVISIBLE);
			floor_image.setVisibility(View.INVISIBLE);
			vi.findViewById(R.id.text).setVisibility(View.INVISIBLE);
		} else {
			floor.setVisibility(View.VISIBLE);
			vi.findViewById(R.id.text).setVisibility(View.VISIBLE);
			floor_image.setVisibility(View.VISIBLE);

		}*/
		
	
		return vi;

	}
}
