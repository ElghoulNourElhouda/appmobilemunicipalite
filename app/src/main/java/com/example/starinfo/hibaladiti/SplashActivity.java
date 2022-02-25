package com.example.starinfo.hibaladiti;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;



public class SplashActivity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashfile);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences prefs = getSharedPreferences("session", MODE_PRIVATE);
                String restoredText = prefs.getString("mail", null);
                if (restoredText != null) {
                    // String mail = prefs.getString("mail", "No mail defined");//"No name defined" is the default value.
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }else {

                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },3000);

    }
}