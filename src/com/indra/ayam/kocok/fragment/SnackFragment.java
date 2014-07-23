package com.indra.ayam.kocok.fragment;

import java.util.ArrayList;

import com.indra.ayam.kocok.R;
import com.indra.ayam.kocok.adapter.ItemListBaseAdapter;
import com.indra.ayam.kocok.model.Items;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SnackFragment extends Fragment {
	
	public static final String KEY_TITLE="title";
	public static final String KEY_DESCRIPTION_DETAIL="descriptionDetail";
	
	public SnackFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_snack, container, false);
        ArrayList<Items> imageDetails = getData();
        final ListView lv1 = (ListView) rootView.findViewById(R.id.listV_main);
        
        final Context context = getActivity().getApplicationContext();
        
        lv1.setAdapter(new ItemListBaseAdapter(context, imageDetails));
        lv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
				Object o = lv1.getItemAtPosition(position);
				Items itemDetails = (Items) o;
				Bundle arguments = new Bundle();
				arguments.putString("name", itemDetails.getName());
				arguments.putString("details", itemDetails.getDescriptionDetail());
				FragmentManager fragmentManager = getFragmentManager();
				Fragment fragment = new SnackDetailFragment();
				fragment.setArguments(arguments);
				fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment).commit();
			}
			
		});
        return rootView;
    }
	
	private ArrayList<Items> getSearchResult(){
		ArrayList<Items> result = new ArrayList<Items>();
		
		Items item = new Items();
		item.setName("Pizza");
		item.setDescription("Spicy Chicken PIzza");
		item.setPrice("Rp. 10,000.00");
		item.setImageNumber(1);
		result.add(item);
		
		item = new Items();
		item.setName("Burger");
		item.setDescription("Beef Burget");
		item.setPrice("Rp. 10,000.00");
		item.setImageNumber(2);
		result.add(item);
		
		item = new Items();
		item.setName("Burger");
		item.setDescription("Beef Burget");
		item.setPrice("Rp. 10,000.00");
		item.setImageNumber(3);
		result.add(item);
		
		item = new Items();
		item.setName("Burger");
		item.setDescription("Beef Burget");
		item.setPrice("Rp. 10,000.00");
		item.setImageNumber(4);		
		result.add(item);
		
		return result;
	}
	
	private ArrayList<Items> getData(){
		ArrayList<Items> newList = new ArrayList<Items>();
		String[] names = getResources().getStringArray(R.array.snack_title);
		String[] descs = getResources().getStringArray(R.array.snack_desc);
		String[] descDetail = getResources().getStringArray(R.array.snack_details);
		String[] prices = getResources().getStringArray(R.array.snack_price);
		TypedArray imgs = getResources().obtainTypedArray(R.array.snack_image);
		for(int i=0; i< names.length; i++){
			Items item = new Items();
			item.setName(names[i]);
			item.setDescription(descs[i]);
			item.setDescriptionDetail(descDetail[i]);
			item.setPrice(prices[i]);
			int t = imgs.getResourceId(i, -1);
			item.setImageNumber(t);
			newList.add(item);
		}
		return newList;
	}
}


