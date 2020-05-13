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

public class CatDogActivity extends ActionBarActivity {
	Button btnBack;
	Button btnCatDogFave;
	DBAdapter myDB;
	TextView tvCatDog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cat_dog);
		
		btnBack = (Button)findViewById(R.id.buttonBackCatDog);
		btnCatDogFave = (Button)findViewById(R.id.buttonCatDogFave);
		tvCatDog = (TextView)findViewById(R.id.textViewCatDogInfo);
		
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
		getMenuInflater().inflate(R.menu.cat_dog, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_cat_dog,
					container, false);
			return rootView;
		}
	}
	public void faveClick(View v){
		myDB.insertRow("Cat & Dog: English Version");
	}
	
	public void populateData(){
		tvCatDog.setText("Title: Cat & Dog (English Version) \n Release Date: May 3rd, 2019 \n Length: 3:08 minutes");
	}
}
