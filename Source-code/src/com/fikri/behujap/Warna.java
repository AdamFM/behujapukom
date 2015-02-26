package com.fikri.behujap;

import android.app.Activity;
import android.os.Bundle;

public class Warna extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_warna);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.animator.right_slide_in1, R.animator.right_slide_out1);
	}
}
