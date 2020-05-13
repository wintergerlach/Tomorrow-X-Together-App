package com.example.tomorrowxtogether;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class ContactActivity extends ActionBarActivity {
	
	Button btnBack;
	EditText etFname;
	EditText etLname;
	EditText etEmail;
	EditText etMessage;
	Button btnSubmit;
	TextView tvOutput;
	TextView tvContact;
	Button btnReturn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		
		btnBack = (Button)findViewById(R.id.buttonContactBack);
		btnSubmit = (Button)findViewById(R.id.buttonSubmit);
		btnReturn = (Button)findViewById(R.id.buttonrReturn);
		etFname = (EditText)findViewById(R.id.editTextFirstName);
		etLname = (EditText)findViewById(R.id.editTextLastName);
		etEmail = (EditText)findViewById(R.id.editTextEmail);
		etMessage = (EditText)findViewById(R.id.editTextMessage);
		tvOutput = (TextView)findViewById(R.id.textViewOutput);
		tvContact = (TextView)findViewById(R.id.textViewContact);
		
		btnBack.setOnClickListener(
				new OnClickListener(){

					@Override
					public void onClick(View v) {
						finish();
						
					}
					
				}
				);
		btnReturn.setVisibility(View.GONE);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_contact,
					container, false);
			return rootView;
		}
	}
	
	public void SubmitClick(View v){
		if((!TextUtils.isEmpty(etFname.getText().toString()))
    			&&(!TextUtils.isEmpty(etLname.getText().toString()))
    			&&(!TextUtils.isEmpty(etEmail.getText().toString()))
    			&&(!TextUtils.isEmpty(etMessage.getText().toString()))){
			String strContact = "";
			strContact = etFname.getText().toString();
			strContact = strContact +" ";
			strContact = strContact + etLname.getText().toString();
			strContact = strContact+"\n";
			strContact = strContact + etEmail.getText().toString();
			strContact = strContact +"\n";
			strContact = strContact + etMessage.getText().toString();
			tvContact.setText("Thank You!");
			tvOutput.setText(strContact);
			etFname.setVisibility(View.GONE);
			etLname.setVisibility(View.GONE);
			etEmail.setVisibility(View.GONE);
			etMessage.setVisibility(View.GONE);
			btnSubmit.setVisibility(View.GONE);
			btnReturn.setVisibility(View.VISIBLE);
		}
	}
	
	public void ReturnClick(View v){
		etFname.getText().clear();
		etLname.getText().clear();
		etEmail.getText().clear();
		etMessage.getText().clear();
		etFname.setVisibility(View.VISIBLE);
		etLname.setVisibility(View.VISIBLE);
		etEmail.setVisibility(View.VISIBLE);
		etMessage.setVisibility(View.VISIBLE);
		btnSubmit.setVisibility(View.VISIBLE);
		btnReturn.setVisibility(View.GONE);
		tvContact.setText("Contact Me!");
		tvOutput.setText("");
	}
	
	

}
