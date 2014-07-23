package com.indra.ayam.activities;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.indra.ayam.kocok.R;
import com.indra.ayam.kocok.adapter.FragmentPagerAdapter;
import com.indra.ayam.kocok.model.Images;

public class ImagePagerFoodView extends FragmentActivity implements
		OnClickListener, OnPageChangeListener {

	private Button btnImagePrevious, btnImageNext;
	private int position = 0, totalImage;
	private ViewPager viewPage;
	private ArrayList<Integer> itemData;
	private FragmentPagerAdapter adapter;
	private String title, description;
	private Images imageId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageview_page);
		Intent intent = getIntent();
		if (null != intent) {
			title = intent.getStringExtra("name");
			description = intent.getStringExtra("details");
		}

		viewPage = (ViewPager) findViewById(R.id.viewPager);
		btnImagePrevious = (Button) findViewById(R.id.btnImagePrevious);
		btnImageNext = (Button) findViewById(R.id.btnImageNext);
		imageId = new Images();
		itemData = imageId.getImageItem();
		totalImage = itemData.size();
		setPage(position);

		adapter = new FragmentPagerAdapter(getSupportFragmentManager(),
				itemData, title, description);
		viewPage.setAdapter(adapter);
		viewPage.setOnPageChangeListener(ImagePagerFoodView.this);

		btnImagePrevious.setOnClickListener(this);
		btnImageNext.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v == btnImagePrevious) {
			position--;
			viewPage.setCurrentItem(position);
		} else if (v == btnImageNext) {
			position++;
			viewPage.setCurrentItem(position);
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int position) {
		this.position = position;
		setPage(position);
	}

	private void setPage(int page) {
		if (page == 0 && totalImage > 0) {
			btnImageNext.setVisibility(View.VISIBLE);
			btnImagePrevious.setVisibility(View.INVISIBLE);
		} else if (page == totalImage - 1 && totalImage > 0) {
			btnImageNext.setVisibility(View.INVISIBLE);
			btnImagePrevious.setVisibility(View.VISIBLE);
		} else {
			btnImageNext.setVisibility(View.VISIBLE);
			btnImagePrevious.setVisibility(View.VISIBLE);
		}
	}
}
