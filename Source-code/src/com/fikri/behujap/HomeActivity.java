package com.fikri.behujap;

import com.fikri.hiragana.Hiragana;
import com.fikri.katakana.Katakana;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

	Button hira, kana, lath, ka, about;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		hira = (Button) findViewById(R.id.BtnHurufHira);
		
		hira.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent hira = new Intent(getApplicationContext(), Hiragana.class);
				startActivity(hira);overridePendingTransition(R.animator.right_slide_out2, R.animator.right_slide_in2);				
			}
		});
		
		kana = (Button) findViewById(R.id.BtnHurufKana);
		
		kana.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent kana = new Intent(getApplicationContext(), Katakana.class);
				startActivity(kana);overridePendingTransition(R.animator.right_slide_out2, R.animator.right_slide_in2);				
			}
		});
		
		lath = (Button) findViewById(R.id.BtnLatHira);
		
		lath.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent hira = new Intent(getApplicationContext(), LatHira1.class);
				startActivity(hira);overridePendingTransition(R.animator.right_slide_out2, R.animator.right_slide_in2);	
			}
		});	
		
		ka = (Button) findViewById(R.id.btnKata);
		
		ka.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent hira = new Intent(getApplicationContext(), Kata.class);
				startActivity(hira);overridePendingTransition(R.animator.right_slide_out2, R.animator.right_slide_in2);	
			}
		});
		
		about = (Button) findViewById(R.id.btnAbout);
		
		about.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent hira = new Intent(getApplicationContext(), About.class);
				startActivity(hira);overridePendingTransition(R.animator.right_slide_out2, R.animator.right_slide_in2);	
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder keluar=new AlertDialog.Builder(this);
        keluar.setMessage("Anda Yakin Ingin Keluar?");
        keluar.setCancelable(false);
        keluar.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            	
                overridePendingTransition(R.animator.fade_in,R.animator.fade_out);
            }
        });
        keluar.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = keluar.create();
        alertDialog.show();
        super.onBackPressed();
	}
}
