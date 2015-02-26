package com.fikri.behujap;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Salam extends Activity implements OnClickListener{

	ImageView img1, img2, img3, img4, img5;
	
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

	            mediaPlayer = MediaPlayer.create(this, R.raw.ohayou);
	        }
	        
	        else if (arg == 1){

	            mediaPlayer = MediaPlayer.create(this, R.raw.konichiwa);
	        }
	        
	        else if (arg == 2){

	            mediaPlayer = MediaPlayer.create(this, R.raw.konbanwa);
	        }
	        
	        else if (arg == 3){

	            mediaPlayer = MediaPlayer.create(this, R.raw.oyasumi);
	        }
	        
	        else if (arg == 4){

	            mediaPlayer = MediaPlayer.create(this, R.raw.sayounara);
	        }
	        mediaPlayer.setLooping(false); // Set looping
	        mediaPlayer.start();
	    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_salam);
		
		img1 = (ImageView)findViewById(R.id.img1);
		img1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				playSound(0);
			}
		});
		
		img2 = (ImageView)findViewById(R.id.img2);
		img2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				playSound(1);
			}
		});
		
		img3 = (ImageView)findViewById(R.id.img3);
		img3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				playSound(2);
			}
		});
		
		img4 = (ImageView)findViewById(R.id.img4);
		img4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				playSound(3);
			}
		});
		
		img5 = (ImageView)findViewById(R.id.img5);
		img5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				playSound(4);
			}
		});
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.animator.right_slide_in1, R.animator.right_slide_out1);
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}
