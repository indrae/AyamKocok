package com.indra.ayam.kocok.fragment;

import com.indra.ayam.kocok.R;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {
	
	private Button button;
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

		// add PhoneStateListener
		PhoneCallListener phoneListener = new PhoneCallListener();
		TelephonyManager telephonyManager = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
		telephonyManager.listen(phoneListener,
				PhoneStateListener.LISTEN_CALL_STATE);
        
        button = (Button) rootView.findViewById(R.id.btnCall);
        
        // add button listener
        button.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:02196596391"));
				startActivity(callIntent);
				return false;
			}
		});
        return rootView;
    }
	
	private class PhoneCallListener extends PhoneStateListener {		
		private boolean isPhoneCalling = false;		
		
		String LOG_TAG = "LOGGING 123";
		
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			if(TelephonyManager.CALL_STATE_RINGING == state){
				Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
			}
			
			if(TelephonyManager.CALL_STATE_OFFHOOK == state){
				Log.i(LOG_TAG, "OFFHOOK");
				
				isPhoneCalling = true;
			}
			
			if(TelephonyManager.CALL_STATE_IDLE == state){
				Log.i(LOG_TAG, "IDLE");
				
				if (isPhoneCalling) {
					 
					Log.i(LOG_TAG, "restart app");
 
					// restart app
					Intent i =getActivity().getApplicationContext().getPackageManager()
						.getLaunchIntentForPackage(
								getActivity().getApplicationContext().getPackageName());
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
 
					isPhoneCalling = false;
				}
			}
		}
	}
}
