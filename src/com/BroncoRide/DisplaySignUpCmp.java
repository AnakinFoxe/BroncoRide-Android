package com.BroncoRide;

import com.broncorider.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplaySignUpCmp extends ActionBarActivity {
	
	public static final String SIGNUP_RESULT = "com.broncorider.SIGNUP_RESULT";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_display_sign_up_cmp);

//		if (savedInstanceState == null) {
//			getFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
		
		Intent intent = getIntent();
//		String result = intent.getStringExtra(DisplaySignUpProgress.RESULT_MESSAGE);
		String result = intent.getStringExtra(SIGNUP_RESULT);
		
//		if (result == "Success") {
//			
//		} else {
//			
//		}
		
		TextView et_signup_result = (TextView) findViewById(R.id.et_signup_result);
		et_signup_result.setTextSize(36);
		et_signup_result.setText("Sign Up Result: " + result);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_sign_up_cmp, menu);
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
			View rootView = inflater.inflate(
					R.layout.fragment_display_sign_up_cmp, container, false);
			return rootView;
		}
	}

}
