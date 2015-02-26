package com.fikri.hiragana.yoon;

import com.fikri.behujap.R;
import com.fikri.behujap.R.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Hira_Byu extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (container == null) {
			return null;
		}
		return (LinearLayout) inflater.inflate(R.layout.hira_byu_layout, 
				container, false);
	}
	
}
