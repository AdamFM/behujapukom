package com.fikri.behujap;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LatHira5 extends Activity implements OnClickListener{

	int nilaipost, nilai, hasil;
	EditText ejawab;
	Button btncek;
	TextView hasil4;
	private MediaPlayer mediaPlayer;
    
	public void OnPause(){
		try{
			super.onPause();
	        mediaPlayer.pause();
	    } catch (Exception e){
	    
	    }
	}

	private void playSound(int arg){
	    try{
	    	if (mediaPlayer.isPlaying()) {
	    		mediaPlayer.stop();
	    		mediaPlayer.release();
	    	}
	    } catch(Exception e){
	            Log.e("error", "blablabla");
	    }
	
	    if (arg == 0){
	    	mediaPlayer = MediaPlayer.create(this, R.raw.benar);
	    }
	    
	    else if (arg == 1) {
	    	mediaPlayer = MediaPlayer.create(this, R.raw.salah2);
	    }
	    
	    mediaPlayer.setLooping(false); // Set looping
	    mediaPlayer.start();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lat_hira5);
		Intent intent = getIntent();
		nilaipost = intent.getIntExtra("nilaidata", 0); 
		hasil4 = (TextView) findViewById(R.id.hasil);
		hasil4.setText(String.valueOf(nilaipost)); 
		ejawab = (EditText) findViewById(R.id.ejawab);
		btncek = (Button) findViewById(R.id.btncek);
		btncek.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lat_hira5, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btncek:
			
			String data = ejawab.getText().toString();
			if (data.equals("")) {
				Toast.makeText(getApplicationContext(), "Isi jawaban", Toast.LENGTH_SHORT).show();
			}
			else {
			if(data.equals("u"))
			{
				nilai = 20;
				hasil = nilaipost + nilai;
				Toast.makeText(getApplicationContext(), "Benar", Toast.LENGTH_SHORT).show();
				playSound(0);
				Intent intent = new Intent(getApplicationContext(), HasilLat.class);
				intent.putExtra("nilaidata", hasil);
				startActivity(intent);finish();
				overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
			}
			else
			{
				nilai = 0;
				Toast.makeText(getApplicationContext(), "Salah", Toast.LENGTH_SHORT).show();
				playSound(1);
				Intent intent = new Intent(getApplicationContext(), HasilLat.class);
				intent.putExtra("nilaidata", nilaipost);
				startActivity(intent);finish();
				overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
			}
			}
			break;

		default:
			break;
		}
	}
}
