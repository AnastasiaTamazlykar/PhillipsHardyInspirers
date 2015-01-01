package com.example.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Настасья on 01.01.2015.
 */
public class CrimeLab {
	private static CrimeLab sCrimeLab;

	private Context mAppContext;
	private ArrayList<Crime> mCrimes;

	private CrimeLab(Context appContext) {
		mAppContext = appContext;
		mCrimes = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Crime crime = new Crime();
			crime.setTitle("Crime #" + i);
			crime.setDate(new Date(i * 99999999));
			crime.setSolved(i % 3 == 0);
			mCrimes.add(crime);
		}
	}

	public static CrimeLab get(Context c) {
		if (sCrimeLab == null)
			sCrimeLab = new CrimeLab(c.getApplicationContext());
		return sCrimeLab;
	}

	public Crime get(UUID id) {
		for (Crime crime : mCrimes) {
			if (crime.getId().equals(id))
				return crime;
		}
		return null;
	}


	public ArrayList<Crime> getCrimes() {
		return mCrimes;
	}
}
