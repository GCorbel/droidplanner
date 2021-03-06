package org.droidplanner.android.fragments.calibration;

import org.droidplanner.R;
import org.droidplanner.android.fragments.SetupRadioFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentSetupNext extends SetupSidePanel {

	private int titleId = 0, descId = 0;
	private TextView textTitle, textDesc;;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final SetupRadioFragment setupFragment = (SetupRadioFragment) getParentFragment();

		final View view = inflater.inflate(R.layout.fragment_setup_panel_next,
				container, false);

		textTitle = (TextView) view.findViewById(R.id.setupTitle);
		textDesc = (TextView) view.findViewById(R.id.setupDesc);

		if (titleId != 0 && textTitle != null)
			textTitle.setText(titleId);

		if (descId != 0)
			textDesc.setText(descId);

		final Button btnNext = (Button) view.findViewById(R.id.buttonNext);
		btnNext.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (setupFragment != null) {
					setupFragment.doCalibrationStep(2);
				}
			}
		});

		final Button btnCancel = (Button) view.findViewById(R.id.buttonCancel);
		btnCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (setupFragment != null) {
					setupFragment.doCalibrationStep(0);
				}
			}
		});
		return view;
	}

	@Override
	public void updateDescription(int idDescription) {
		this.descId = idDescription;

		if (textDesc != null)
			textDesc.setText(descId);

	}

	@Override
	public void updateTitle(int idTitle) {
		this.titleId = idTitle;

		if (textTitle != null)
			textTitle.setText(titleId);
	}
}
