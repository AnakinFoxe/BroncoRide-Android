package com.BroncoRide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.BroncoRide.Entity.CarInfo;
import com.BroncoRide.Entity.Place;
import com.BroncoRide.Entity.Rank;
import com.BroncoRide.Entity.Users;
import com.BroncoRide.Util.GetLocation;
import com.broncorider.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

public class DisplaySignUpProfile extends ActionBarActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_display_sign_up_profile);

//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_sign_up_profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater
					.inflate(R.layout.fragment_display_sign_up_profile,
							container, false);
			return rootView;
		}
	}
	
	
	/** Called when the user clicks the Submit button */
	public void sendProfile(View view) {
		
		// Password
		EditText et_password = (EditText) findViewById(R.id.et_password);
		String password = et_password.getText().toString();
		EditText et_password2 = (EditText) findViewById(R.id.et_password2);
		String password2 = et_password2.getText().toString();
		if ((password != null) && (!password.equals(password2))) {
			// TODO: error handling
		}
		
		// Gender
		RadioGroup rg_gender = (RadioGroup) findViewById(R.id.rg_gender);
		RadioButton rb_selected = (RadioButton) findViewById(rg_gender.getCheckedRadioButtonId());
		String gender = rb_selected.getText().toString();
		
		// Age
		EditText et_age = (EditText) findViewById(R.id.et_age);
		String age = et_age.getText().toString();
		
		// Home Address
		EditText et_home_addr = (EditText) findViewById(R.id.et_home_addr);
		String home_addr = et_home_addr.getText().toString();
		EditText et_home_city = (EditText) findViewById(R.id.et_home_city);
		String home_city = et_home_city.getText().toString();
		EditText et_home_state = (EditText) findViewById(R.id.et_home_state);
		String home_state = et_home_state.getText().toString();
		
		// Dest Address
		EditText et_dest_addr = (EditText) findViewById(R.id.et_dest_addr);
		String dest_addr = et_dest_addr.getText().toString();
		EditText et_dest_city = (EditText) findViewById(R.id.et_dest_city);
		String dest_city = et_dest_city.getText().toString();
		EditText et_dest_state = (EditText) findViewById(R.id.et_dest_state);
		String dest_state = et_dest_state.getText().toString();
		
		// Car Info
		CheckBox cb_car = (CheckBox) findViewById(R.id.cb_car);
		String drv_age = "";
		String car_year = "";
		String car_model = "";
		String car_seats = "";
		if (cb_car.isChecked()) {
			EditText et_drv_age = (EditText) findViewById(R.id.et_drv_age);
			drv_age = et_drv_age.getText().toString();
			EditText et_car_year = (EditText) findViewById(R.id.et_car_year);
			car_year = et_car_year.getText().toString();
			EditText et_car_model = (EditText) findViewById(R.id.et_car_model);
			car_model = et_car_model.getText().toString();
			EditText et_car_seats = (EditText) findViewById(R.id.et_car_seats);
			car_seats = et_car_seats.getText().toString();
		} 
		
		Integer debug = 1;
		if (debug == 1) {
			password = "1234";
			gender = "Male";
			age = "23";
			home_addr = "nancy st";
			home_city = "west covina";
			home_state = "ca";
			dest_addr = "cal poly pomona";
			dest_city = "pomona";
			dest_state = "ca";
			drv_age = "3";
			car_year = "2010";
			car_model = "tesla model s";
			car_seats = "4";
		}
		
		// TODO: Geocoder not tested yet
//		Geocoder coder = new Geocoder(this);
//		double home_lat = 0;
//		double home_log = 0;
//		double dest_lat = 0;
//		double dest_log = 0;
//		try {
//			List<Address> address = coder.getFromLocationName(
//										home_addr 
//										+ " " + home_city
//										+ " " + home_state, 5);
//			List<Address> address = coder.getFromLocationName("1901 East Amar Road, West Covina, CA", 5);
//			
//		    if (address != null) {
//		    	Address location = address.get(0);
//		    	home_lat = location.getLatitude();
//		    	home_log = location.getLongitude();
//		    } 
//		    
////		    address = coder.getFromLocationName(
////										dest_addr 
////										+ " " + dest_city
////										+ " " + dest_state, 5);
//		    address = coder.getFromLocationName(
//		    							"Cal Poly Pomona, W Temple Ave, Pomona, CA", 5);
//		    
//			if (address != null) {
//				Address location = address.get(0);
//				dest_lat = location.getLatitude();
//				dest_log = location.getLongitude();
//			} 
//		    
//		} catch (Exception e) {
//			e.printStackTrace();
//	    	System.out.println(e.getMessage());
//		}
		LatLng home_coor = new LatLng(0, 0);
		LatLng dest_coor = new LatLng(0, 0);
		try {
			//home_coor = Utils.getLocationFromString("1901 East Amar Road, West Covina, CA");
			//dest_coor = Utils.getLocationFromString("Cal Poly Pomona, W Temple Ave, Pomona, CA");
			home_coor = new GetLocation().execute("1901 East Amar Road, West Covina, CA").get();
			dest_coor = new GetLocation().execute("Cal Poly Pomona, W Temple Ave, Pomona, CA").get();
		} catch (Exception e) {
			e.printStackTrace();
	    	System.out.println(e.getMessage());
		}
		
		Place home = new Place(home_addr
							+ "," + home_city
							+ "," + home_state, 
							home_coor.latitude, home_coor.longitude);	
		
		Place dest = new Place(dest_addr
							+ "," + dest_city
							+ "," + dest_state, 
							dest_coor.latitude, dest_coor.longitude);	
		
		CarInfo car = new CarInfo(Integer.parseInt(car_year), 
							car_model, 
							Integer.parseInt(car_seats));
		
		Users user = new Users("xingh@csupomona.edu", 
								password, 
								gender,
								Integer.parseInt(age), 
								Integer.parseInt(drv_age), 
								null, 
								"xingh@csupomona.edu",
								car, home, dest, new Rank(0, 0),
								null);
	    
	    try {
	    	Gson gson = new Gson();  	
	    	String str_json = gson.toJson(user);
	    	String result = new SendProfile().execute(str_json).get();
	    	
	    	//String result = "Success";
	    	
	    	Intent intent = new Intent(this, DisplaySignUpCmp.class);
	    	
	    	if (result != null){
	    		intent = new Intent(this, DisplaySignUpCmp.class);
	    		intent.putExtra(DisplaySignUpCmp.SIGNUP_RESULT, result);
			    startActivity(intent);
	    	} 
	    		
//		    intent.putExtra(RESULT_MESSAGE, result);
		    startActivity(intent);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.println(e.getMessage());
		}
	
	}

}
