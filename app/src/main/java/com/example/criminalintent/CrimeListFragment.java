package com.example.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Настасья on 01.01.2015.
 */
public class CrimeListFragment extends ListFragment {
	private final String TAG = "CrimeListFragment";
	private ArrayList<Crime> mCrimes;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crimes_title);
		mCrimes = CrimeLab.get(getActivity()).getCrimes();
		CrimeAdapter adapter = new CrimeAdapter(mCrimes);
		setListAdapter(adapter);

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
		Intent intent = new Intent(getActivity(),CrimeActivity.class);
		intent.putExtra(CrimeFragment.EXTRA_CRIME_ID,c.getId());
		startActivity(intent);

	}

	private class CrimeAdapter extends ArrayAdapter<Crime> {
		public CrimeAdapter(ArrayList<Crime> crimes) {
			super(getActivity(), 0, crimes);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null)
				convertView = getActivity().getLayoutInflater().inflate(R.layout.crime_item, null);
			Crime c = getItem(position);
			TextView mTitle = (TextView) convertView.findViewById(R.id.crime_item_title);
			TextView mDate = (TextView) convertView.findViewById(R.id.crime_item_crime_date);
			CheckBox mSolved = (CheckBox) convertView.findViewById(R.id.crime_item_checkBox_solved);
			mTitle.setText(c.getTitle());
			mDate.setText(new SimpleDateFormat("EEEE, MMM d, y").format(c.getDate()));
			mSolved.setChecked(c.isSolved());
		return convertView;
		}
	}

}

