package com.indra.ayam.kocok.adapter;

import java.util.ArrayList;

import com.indra.ayam.kocok.R;
import com.indra.ayam.kocok.model.Items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemListBaseAdapter extends BaseAdapter{
	
	private static ArrayList<Items> itemDetailsList;
	private LayoutInflater lInflater;
	
	private Integer[] imgId = {
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
	};
	
	public ItemListBaseAdapter(Context context, ArrayList<Items> result){
		itemDetailsList = result;
		lInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itemDetailsList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return itemDetailsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if(convertView == null){
			convertView = lInflater.inflate(R.layout.activity_list_view_images, null);
			holder = new ViewHolder();
			holder.txt_itemName = (TextView) convertView.findViewById(R.id.name);
//			holder.txt_description = (TextView) convertView.findViewById(R.id.itemDescription);
//			holder.txt_itemPrice = (TextView) convertView.findViewById(R.id.price);
			holder.itemImage = (ImageView)convertView.findViewById(R.id.photo);
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.txt_itemName.setText(itemDetailsList.get(position).getName());
//		holder.txt_description.setText(itemDetailsList.get(position).getDescription());
//		holder.txt_itemPrice.setText(itemDetailsList.get(position).getPrice());
		holder.itemImage.setImageResource(itemDetailsList.get(position).getImageNumber());
		
		return convertView;
	}
	
	static class ViewHolder{
		TextView txt_itemName;
		TextView txt_description;
		TextView txt_itemPrice;
		ImageView itemImage;
	}
}
