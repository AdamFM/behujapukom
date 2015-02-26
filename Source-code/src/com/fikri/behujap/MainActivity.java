package com.fikri.behujap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	private static int splash = 2050;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new android.os.Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent show = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(show);
                overridePendingTransition(R.animator.fade_in, R.animator.fade_out);
                finish();         
            }
        },splash);
    }
}
