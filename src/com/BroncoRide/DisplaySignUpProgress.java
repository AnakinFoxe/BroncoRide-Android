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
import android.widget.EditText;
import android.widget.TextView;

public class DisplaySignUpProgress extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_display_sign_up_progress);

		// Xing: dont need these
//		if (savedInstanceState == null) {
//			getFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
		
		Intent intent = getIntent();
		String email = intent.getStringExtra(MainActivity.EMAIL_MESSAGE);
		
		// Welcome
		// Xing: need to use findViewById after setContentView of the corresponding View, i.e. fragment_xxx
		TextView tv_welcome = (TextView) findViewById(R.id.tv_welcome);
		tv_welcome.setTextSize(24);
		tv_welcome.setText("Welcome! " + email + " Please enter Verification Code");

		
//		findViewById(R.layout.fragment_display_sign_up_progress).invalidate();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_sign_up_progress, menu);
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
					R.layout.fragment_display_sign_up_progress, container,
					false);
			return rootView;
		}
	}
	
	/** Called when the user clicks the Submit button */
	public void sendVCode(View view) {
		Intent intent;
		
		EditText et_vcode = (EditText) findViewById(R.id.et_signup_vcode);
	    String vcode = et_vcode.getText().toString();
	    
	    try {
	    	String result = new SendVCode().execute(vcode, "xingh@csupomona.edu").get();
	    	
	    	//String result = "Success";
	    	
	    	if (result.equals("Success")) {
	    		intent = new Intent(this, DisplaySignUpProfile.class);  
//	    		intent = new Intent(this, DisplaySignUpCmp.class);
	    	} else {
	    		intent = new Intent(this, DisplaySignUpCmp.class);
	    	}
	    		
		    intent.putExtra(DisplaySignUpCmp.SIGNUP_RESULT, result);
		    startActivity(intent);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.println(e.getMessage());
		}
	
	}

}
