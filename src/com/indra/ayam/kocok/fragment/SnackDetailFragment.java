package com.indra.ayam.kocok.fragment;

import com.indra.ayam.kocok.R;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SnackDetailFragment extends Fragment {
	public static final String ARG_ITEM_ID = "item_id";
	
	public SnackDetailFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		String title = getArguments().getString("name");
		String description = getArguments().getString("details");
        View rootView = inflater.inflate(R.layout.activity_item_details, container, false);
        
        TextView titlesTxt = (TextView) rootView.findViewById(R.id.titles);
		titlesTxt.setText(title);
		
		TextView descriptionTxt = (TextView) rootView.findViewById(R.id.descriptions);
		descriptionTxt.setText(description);
		
        return rootView;
    }
}
