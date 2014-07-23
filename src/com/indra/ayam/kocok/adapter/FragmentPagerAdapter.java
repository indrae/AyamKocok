package com.indra.ayam.kocok.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.indra.ayam.kocok.fragment.FoodDetailFragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

	private ArrayList<Integer> itemData;
	private String title;
	private String description;

	public FragmentPagerAdapter(FragmentManager fm,
			ArrayList<Integer> itemData, String title, String desc) {
		super(fm);
		this.itemData = itemData;
		this.title = title;
		this.description = desc;
		
	}

	@Override
	public int getCount() {
		return itemData.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
	}

	@Override
	public Fragment getItem(int position) {
		FoodDetailFragment f = FoodDetailFragment.newInstance();
		f.setImageList(itemData.get(position));
		f.setTitle(title);
		f.setDescription(description);
		return f;
	}
}