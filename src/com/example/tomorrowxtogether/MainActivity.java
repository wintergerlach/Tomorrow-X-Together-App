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
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	
	Button btnMembers;
	Button btnDiscography;
	Button btnFavorites;
	Button btnContact;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnMembers = (Button)findViewById(R.id.buttonMmebers);
        btnDiscography = (Button)findViewById(R.id.buttonDiscography);
        btnFavorites = (Button)findViewById(R.id.buttonFavorites);
        btnContact = (Button)findViewById(R.id.buttonContact);
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public void MembersClick(View v){
    	final Intent intent = new Intent(this, MembersActivity.class);
		startActivity(intent);
    	
    }
    
    public void DiscographyClick(View v){
    	final Intent intent = new Intent(this, DiscographyActivity.class);
		startActivity(intent);
    	
    }

    public void FavoritesClick(View v){
    	final Intent intent = new Intent(this, FavoritesActivity.class);
		startActivity(intent);
	
    }
    
    public void ContactClick(View v){
    	final Intent intent = new Intent(this, ContactActivity.class);
		startActivity(intent);
	
    }

}
