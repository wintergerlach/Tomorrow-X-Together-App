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

public class HueningKaiActivity extends ActionBarActivity {

	Button btnBack;
	Button btnKaiFave;
	DBAdapter myDB;
	TextView tvKai;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_huening_kai);
		
		btnBack = (Button)findViewById(R.id.buttonKaiBack);
		btnKaiFave = (Button)findViewById(R.id.buttonKaiFave);
		tvKai = (TextView)findViewById(R.id.textViewKaiPlaceHolder);
		
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
		getMenuInflater().inflate(R.menu.huening_kai, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_huening_kai,
					container, false);
			return rootView;
		}
	}
	
	public void faveClick(View v){
		myDB.insertRow("Huening Kai");
	}
	
	public void populateData(){
		tvKai.setText("Name: Kai Kamal Huening \n Date of Birth: August 14th, 2002 \n From: Honolulu \n Stage Name: Huening Kai \n Fun Fact: Can speak Mandarin Chinese, Korean, English and Portuguese");
	}
}
