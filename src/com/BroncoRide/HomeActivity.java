package com.BroncoRide;

import com.broncorider.R;
import com.broncorider.R.id;
import com.broncorider.R.layout;
import com.broncorider.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class HomeActivity extends ActionBarActivity {

	public static final String MODE_TYPE = "com.broncoRider.MODE_TYPE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_home, container,
					false);
			return rootView;
		}
	}
	
	/** Called when the user clicks the "I'm driving" button */
	public void driverMode(View view) {
	
	    try {
    		Intent intent = new Intent(this, CreateEvent.class);
    		intent.putExtra(MODE_TYPE, "Driver");
    		startActivity(intent);

	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.println(e.getMessage());
		}
	
	}
	
	/** Called when the user clicks the "I need a ride" button */
	public void passengerMode(View view) {

	    try {
    		Intent intent = new Intent(this, CreateEvent.class);
    		intent.putExtra(MODE_TYPE, "Passenger");
    		startActivity(intent);

	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.println(e.getMessage());
		}
	
	}

}
