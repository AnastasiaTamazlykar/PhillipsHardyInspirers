package com.example.criminalintent;

import android.support.v4.app.Fragment;
import android.view.Menu;


public class CrimeListActivity extends SingleFragmentActivity {

	@Override
	public Fragment createFragment() {
		return new CrimeListFragment();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.menu_crime_list, menu);
			return true;
		}
}