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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MembersActivity extends ActionBarActivity {

	Button btnBack;
	Button btnBeomgyu;
	Button btnKai;
	Button btnSoobin;
	Button btnYeonjun;
	Button btnTaehyun;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_members);
		
		btnBack = (Button)findViewById(R.id.buttonMemberBack2);
		btnBeomgyu = (Button)findViewById(R.id.buttonBeomgyu);
		btnKai = (Button)findViewById(R.id.buttonKai);
		btnSoobin = (Button)findViewById(R.id.buttonSoobin);
		btnYeonjun = (Button)findViewById(R.id.buttonYeonjun);
		btnTaehyun = (Button)findViewById(R.id.buttonTaehyun);
		
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
		getMenuInflater().inflate(R.menu.members, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_members,
					container, false);
			return rootView;
		}
	}
	
	public void TaehyunClick(View v){
		final Intent intent = new Intent(this, TaehyunActivity.class);
		startActivity(intent);
	}
	
	public void KaiClick(View v){
		final Intent intent = new Intent(this, HueningKaiActivity.class);
		startActivity(intent);
	}
	
	public void BeomgyuClick(View v){
		final Intent intent = new Intent(this, BeomgyuActivity.class);
		startActivity(intent);
	}
	
	public void SoobinClick(View v){
		final Intent intent = new Intent(this, SoobinActivity.class);
		startActivity(intent);
	}
	
	public void YeonjunClick(View v){
		final Intent intent = new Intent(this, YeonjunActivity.class);
		startActivity(intent);
	}

}
