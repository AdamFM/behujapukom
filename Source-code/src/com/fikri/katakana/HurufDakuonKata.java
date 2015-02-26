package com.fikri.katakana;

import com.fikri.behujap.R;
import com.fikri.behujap.R.layout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HurufDakuonKata extends android.app.Fragment{
	View rootview;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootview = inflater.inflate(R.layout.hurufdakuonkata, container, false);
		return rootview;
	}
}
