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

public class MainActivity extends ActionBarActivity {
	
	public static final String EMAIL_MESSAGE = "com.broncorider.EMAIL_MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	/** Called when the user clicks the Sign Up button */
	public void sendSignUp(View view) {
		Intent intent = new Intent(this, DisplaySignUpProgress.class);
		
		EditText et_email = (EditText) findViewById(R.id.signup_email);
	    String email = et_email.getText().toString();
	    

	    try {
	    	new SendSignUp().execute(email);
	    	
    		intent.putExtra(EMAIL_MESSAGE, email);
		    startActivity(intent);
   
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.println(e.getMessage());
		}
	
	}
	
	/** Called when the user clicks the Sign In button */
	public void sendSignIn(View view) {
	
		EditText et_email = (EditText) findViewById(R.id.signup_email);
	    String email = et_email.getText().toString();
	    
	    EditText et_password = (EditText) findViewById(R.id.signin_password);
	    String password = et_password.getText().toString();

	    try {
	    	String result = new SendSignIn().execute(email, password).get();
	    	
	    	result = "Success";
	    	
	    	if ((result != null) && (result.equals("Success"))) {
	    		Intent intent = new Intent(this, HomeActivity.class);
	    		startActivity(intent);
	    	} else {
	    		// TODO: Sign In failure dialog
	    		et_email.setText("");
	    		et_password.setText("");
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.println(e.getMessage());
		}
	
	}

}
