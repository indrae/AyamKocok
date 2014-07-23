package com.indra.ayam.kocok.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import com.indra.ayam.kocok.R;

public class Images {

	private Random randNo;
	private ArrayList<Integer> imageId;

	public Images() {
		imageId = new ArrayList<Integer>();
		imageId.add(R.drawable.ic_launcher);
		imageId.add(R.drawable.ic_launcher);
		imageId.add(R.drawable.ic_launcher);
		imageId.add(R.drawable.ic_launcher);
		imageId.add(R.drawable.ic_launcher);
	}

	public int getImageId() {
		randNo = new Random();
		return imageId.get(randNo.nextInt(imageId.size()));
	}

	public ArrayList<Integer> getImageItem() {
		return imageId;
	}
}
