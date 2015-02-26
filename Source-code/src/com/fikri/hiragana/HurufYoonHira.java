package com.fikri.hiragana;

import com.fikri.behujap.R;
import com.fikri.behujap.R.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HurufYoonHira extends android.app.Fragment{
	View rootview;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootview = inflater.inflate(R.layout.hurufyoonhira, container, false);
		return rootview;
	}

}
