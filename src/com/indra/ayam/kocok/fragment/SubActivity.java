package com.indra.ayam.kocok.fragment;

import com.indra.ayam.kocok.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.indra.ayam.kocok.fragment.FoodsFragment.KEY_DESCRIPTION_DETAIL;
import static com.indra.ayam.kocok.fragment.FoodsFragment.KEY_TITLE;

public class SubActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_detail);
		

		String title = "";
		String description = "";
		
		Intent intent = getIntent();
		if (null != intent) {
			title = intent.getStringExtra(KEY_TITLE);
			description = intent.getStringExtra(KEY_DESCRIPTION_DETAIL);
		}
		
		TextView titlesTxt = (TextView) findViewById(R.id.titles);
		titlesTxt.setText(title);
		
		TextView descriptionTxt = (TextView) findViewById(R.id.descriptions);
		descriptionTxt.setText(description);
	}
}
