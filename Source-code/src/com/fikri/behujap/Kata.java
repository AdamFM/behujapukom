package com.fikri.behujap;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Kata extends Activity {

Button salam, warna;
	
	MediaPlayer mediaPlayer;
	 private void playSound(int arg){
	        try{
	            if (mediaPlayer.isPlaying()) {
	                mediaPlayer.stop();
	                mediaPlayer.release();
	            }
	        }catch(Exception e){
	            Log.e("error", "blablabla");
	        }
	        if (arg == 0){

	            mediaPlayer = MediaPlayer.create(this, R.raw.page);
	        }
	        mediaPlayer.setLooping(false); // Set looping
	        mediaPlayer.start();
	    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kata);
		
		salam = (Button) findViewById(R.id.btnSalam);
		
		salam.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent hira = new Intent(getApplicationContext(), Salam.class);
				startActivity(hira);overridePendingTransition(R.animator.right_slide_out2, R.animator.right_slide_in2);	
				playSound(0);
			}
		});
		
		warna = (Button) findViewById(R.id.btnWarna);
		
		warna.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent kana = new Intent(getApplicationContext(), Warna.class);
				startActivity(kana);overridePendingTransition(R.animator.right_slide_out2, R.animator.right_slide_in2);
				playSound(0);
			}
		});
	}
	
	@Override
		public void onBackPressed() {
			// TODO Auto-generated method stub
			super.onBackPressed();
			overridePendingTransition(R.animator.right_slide_in1, R.animator.right_slide_out1);	
	}
}
