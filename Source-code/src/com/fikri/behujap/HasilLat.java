package com.fikri.behujap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HasilLat extends Activity {

	TextView hasil;
	int nilaipost;
	Button btnulang, btnlanjut, btnkembali;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hasil_lat);
		Intent intent = getIntent();
		nilaipost = intent.getIntExtra("nilaidata", 0); 
		hasil = (TextView) findViewById(R.id.hasil);
		
		hasil.setText(String.valueOf(nilaipost));
		
		btnulang = (Button)findViewById(R.id.btnulang);
		btnkembali = (Button)findViewById(R.id.btnkembali);
		
		btnulang.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent show = new Intent(getApplicationContext(), LatHira1.class);
				startActivity(show);
				
				HasilLat.this.finish();
				
			}
		});
		
		btnkembali.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent show = new Intent(getApplicationContext(), HomeActivity.class);
				startActivity(show);
				
				HasilLat.this.finish();
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hasil_lat, menu);
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
}
