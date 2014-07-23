package com.indra.ayam.kocok.fragment;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.indra.ayam.kocok.R;

public class FoodDetailFragment extends Fragment {
	public static final String ARG_ITEM_ID = "item_id";
	
	private Integer itemData;
	private String title;
	private String description;
	private Bitmap myBitmap;
	public ProgressDialog pd;
	private ImageView ivImage;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
//		String title = getArguments().getString("name");
//		String description = getArguments().getString("details");
		String titles = title;
		String descriptions = description;
        View rootView = inflater.inflate(R.layout.activity_item_details, container, false);
//		ivImage = (ImageView) rootView.findViewById(R.id.image);
        setImageInViewPager();
        
        TextView titlesTxt = (TextView) rootView.findViewById(R.id.titles);
		titlesTxt.setText(titles);
		
		TextView descriptionTxt = (TextView) rootView.findViewById(R.id.descriptions);
		descriptionTxt.setText(descriptions);
		descriptionTxt.setMovementMethod(new ScrollingMovementMethod());
		
        return rootView;
    }

	public static FoodDetailFragment newInstance() {
		FoodDetailFragment f = new FoodDetailFragment();
		return f;
	}

	public void setImageList(Integer integer) {
		this.itemData = integer;
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageInViewPager() {
		try {
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			myBitmap = BitmapFactory.decodeResource(getResources(), itemData,
					options);
			if (options.outWidth > 3000 || options.outHeight > 2000) {
				options.inSampleSize = 4;
			} else if (options.outWidth > 2000 || options.outHeight > 1500) {
				options.inSampleSize = 3;
			} else if (options.outWidth > 1000 || options.outHeight > 1000) {
				options.inSampleSize = 2;
			}
			options.inJustDecodeBounds = false;
			myBitmap = BitmapFactory.decodeResource(getResources(), itemData,
					options);
			if (myBitmap != null) {
				try {
					if (ivImage != null) {
						ivImage.setImageBitmap(myBitmap);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
			System.gc();
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if (myBitmap != null) {
			myBitmap.recycle();
			myBitmap = null;
		}
	}
	
}
