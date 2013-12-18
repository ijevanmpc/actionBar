package com.example.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	private void showPopupMenu() {
		View v = (View) findViewById(R.id.action_settings);
		PopupMenu popupMenu = new PopupMenu(this, v);
		popupMenu.getMenuInflater().inflate(R.menu.main, popupMenu.getMenu());

		popupMenu
				.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						Toast.makeText(getApplicationContext(),
								item.toString(), Toast.LENGTH_LONG).show();
						return true;
					}
				});
		popupMenu.show();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.action_settings:
			showPopupMenu();
			return true;
		}
		return false;
	}
}
