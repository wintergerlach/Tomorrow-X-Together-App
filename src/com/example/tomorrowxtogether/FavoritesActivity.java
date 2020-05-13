package com.example.tomorrowxtogether;

import java.io.Console;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.os.Build;

public class FavoritesActivity extends ActionBarActivity {
	Button btnBack;
	DBAdapter myDB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favorites);
		
		btnBack = (Button)findViewById(R.id.buttonFavoritesBack);
		
		myDB = new DBAdapter(this);
		myDB.open();
		
		populateListView();
		listViewItemClick();
		listViewLongItemClick();
		
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
		getMenuInflater().inflate(R.menu.favorites, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_favorites,
					container, false);
			return rootView;
		}
	}
	
	public void populateListView(){
		Cursor cursor = myDB.getAllRows();
		String[] fromFieldName = new String[]{DBAdapter.KEY_FAVE};
		int[] toViewID = new int[]{R.id.textViewItemFave};
		SimpleCursorAdapter myCursorAdapter;
		myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.item_layout, cursor, fromFieldName, toViewID, 0);
		ListView myList = (ListView)findViewById(R.id.listView1);
		myList.setAdapter(myCursorAdapter);
		
	}
	private void listViewItemClick(){
		ListView myList = (ListView)findViewById(R.id.listView1);
		final Intent soobin = new Intent(this, SoobinActivity.class);
		final Intent kai = new Intent(this, HueningKaiActivity.class);
		final Intent yeonjun = new Intent(this, YeonjunActivity.class);
		final Intent taehyun = new Intent(this, TaehyunActivity.class);
		final Intent beomgyu = new Intent(this, BeomgyuActivity.class);
		final Intent magic = new Intent(this, MagicActivity.class);
		final Intent star = new Intent(this, StarActivity.class);
		final Intent catDog = new Intent(this, CatDogActivity.class);
		final Intent ourSummer = new Intent(this, OurSummerActivity.class);
		
		myList.setOnItemClickListener(
				new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						Cursor cursor = myDB.getRow(id);
				    	if(cursor.moveToFirst()){
				    		String fave = cursor.getString(DBAdapter.COL_FAVE);
							if(fave.equals("Soobin")){
								startActivity(soobin);
							}	
							if(fave.equals("Yeonjun")){
								startActivity(yeonjun);
							}
							if(fave.equals("Huening Kai")){
								startActivity(kai);
							}
							if(fave.equals("Taehyun")){
								startActivity(taehyun);
							}
							if(fave.equals("Beomgyu")){
								startActivity(beomgyu);
							}
							if(fave.equals("Cat & Dog: English Version")){
								startActivity(catDog);
							}
							if(fave.equals("The Dream Chapter: Magic")){
								startActivity(magic);
							}
							
							if(fave.equals("Our Summer: Acoustic Version")){
								startActivity(ourSummer);
							}
							if(fave.equals("The Dream Chapter: Star")){
								startActivity(star);
							}
				    	}
					}
				}
				);
	}
	private void listViewLongItemClick(){
		ListView myList = (ListView)findViewById(R.id.listView1);
		myList.setOnItemLongClickListener(
				new AdapterView.OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, int position, long id) {
						// TODO Auto-generated method stub
						myDB.deleteRow(id);
						populateListView();
						return false;
					}
				});
	}
}
