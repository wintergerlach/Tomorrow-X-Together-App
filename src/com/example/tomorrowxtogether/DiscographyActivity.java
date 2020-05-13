package com.example.tomorrowxtogether;

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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Build;

public class DiscographyActivity extends ActionBarActivity {
	
	Button btnBack;
	Button btnStar;
	Button btnMagic;
	Button btnCatDog;
	Button btnOurSummer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discography);
		
		btnBack = (Button)findViewById(R.id.buttonDiscographyBack);
		btnStar = (Button)findViewById(R.id.buttonStar);
		btnMagic = (Button)findViewById(R.id.buttonMagic);
		btnCatDog = (Button)findViewById(R.id.buttonCatDog);
		btnOurSummer = (Button)findViewById(R.id.buttonOurSummer);
		
		btnBack.setOnClickListener(
				new OnClickListener(){

					@Override
					public void onClick(View v) {
						finish();
						
					}
					
				}
				);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.discography, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_discography,
					container, false);
			return rootView;
		}
	}
	
	public void CatDogClick(View v){
		final Intent intent = new Intent(this, CatDogActivity.class);
		startActivity(intent);
	}
	
	public void OurSummerClick (View v){
		final Intent intent = new Intent(this, OurSummerActivity.class);
		startActivity(intent);
	}
	
	public void MagicClick(View v){
		final Intent intent = new Intent(this, MagicActivity.class);
		startActivity(intent);
	}
	
	public void StarClick(View v){
		final Intent intent = new Intent(this, StarActivity.class);
		startActivity(intent);
	}
	

}
