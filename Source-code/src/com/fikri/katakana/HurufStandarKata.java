package com.fikri.katakana;

import com.fikri.behujap.R;
import com.fikri.behujap.R.layout;

import net.simonvt.menudrawer.MenuDrawer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HurufStandarKata extends android.app.Fragment{
	View rootview;
	MenuDrawer mDrawer;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		rootview = inflater.inflate(R.layout.hurufstandarkata, container, false);
		return rootview;
	}

}
