package com.example.tomorrowxtogether;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class MagicActivity extends ActionBarActivity {
	
	Button btnBack;
	Button btnMagicFave;
	DBAdapter myDB;
	TextView tvMagic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_magic);
		
		btnBack = (Button)findViewById(R.id.buttonMagicBack);
		btnMagicFave = (Button)findViewById(R.id.buttonMagicFave);
		tvMagic = (TextView)findViewById(R.id.textViewMagic);
		
		myDB = new DBAdapter(this);
		myDB.open();
		
		btnBack.setOnClickListener(
				new OnClickListener(){

					@Override
					public void onClick(View v) {
						finish();
						
					}
					
				}
				);

		populateData();
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.magic, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_magic,
					container, false);
			return rootView;
		}
	}
	
	public void faveClick(View v){
		myDB.insertRow("The Dream Chapter: Magic");
	}
	
	public void populateData(){
		tvMagic.setText("Album: The Dream Chapter: Magic \n Release Date: October 21, 2019 \n Length: 27 minutes \n Tracks: \n New Rules \n 9 and Three Quarters(Run Away) \n Roller Coaster \n Poppin' Star \n Can't We Just Leave The Monster Alive \n Magic Island \n 20cm \n Angel or Devil");
	}
}
