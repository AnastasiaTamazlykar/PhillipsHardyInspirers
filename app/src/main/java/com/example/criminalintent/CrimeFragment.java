package com.example.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Настасья on 31.12.2014.
 */
public class CrimeFragment extends Fragment {
	public static final String EXTRA_CRIME_ID="com/example/criminalintent/CrimeFragment/crime_id";
	private Crime mCrime;
	private EditText mTitleField;
	private Button mDateButton;
	private CheckBox mSolved;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UUID crimeId = (UUID)getArguments().getSerializable(EXTRA_CRIME_ID);
		mCrime = CrimeLab.get(getActivity()).get(crimeId);
		mCrime.setDate(new Date());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.crime_fragment, parent, false);
		mTitleField = (EditText) v.findViewById(R.id.crime_title);
		mDateButton = (Button) v.findViewById(R.id.button_date);
		mSolved = (CheckBox) v.findViewById(R.id.checkBox_solved);
		mTitleField.setText(mCrime.getTitle());
		mDateButton.setText(new SimpleDateFormat("EEEE, MMM d, y").format(mCrime.getDate()));
		mSolved.setChecked(mCrime.isSolved());
		mSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mCrime.setSolved(isChecked);
			}
		});
		mTitleField.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mCrime.setTitle(s.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		return v;
	}

	public static CrimeFragment newInstance(UUID uuid){
		Bundle args= new Bundle();
		args.putSerializable(EXTRA_CRIME_ID,uuid);
		CrimeFragment fragment= new CrimeFragment();
		fragment.setArguments(args);
		return fragment;
	}

}