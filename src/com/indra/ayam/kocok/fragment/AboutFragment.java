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

public class AboutFragment extends Fragment {
	
	public static final String KEY_TITLE="title";
	public static final String KEY_DESCRIPTION_DETAIL="descriptionDetail";
	
	public AboutFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        
        return rootView;
    }
		
}


