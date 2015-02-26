package com.fikri.hiragana;

import com.fikri.behujap.R;
import com.fikri.hiragana.gojuon.Gojuon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class HurufStandarHira extends android.app.Fragment implements OnClickListener{
	View rootview;
	Button huruf;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		rootview = inflater.inflate(R.layout.hurufstandarhira, container, false);
		huruf = (Button) rootview.findViewById(R.id.btnhuruf);
		huruf.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(), Gojuon.class);
				startActivity(i);
			}
		});
		return rootview;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
