package com.example.criminalintent;

import android.support.v4.app.Fragment;
import android.view.Menu;


public class CrimeActivity extends SingleFragmentActivity {
	@Override
	public Fragment createFragment() {
		return new CrimeFragment();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_crime, menu);
		return true;
	}
}
