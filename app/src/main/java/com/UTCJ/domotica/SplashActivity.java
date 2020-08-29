package com.UTCJ.domotica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private final int DURACION_SPLASH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            public void run(){

                Intent intent = new Intent(SplashActivity.this, MainLogin.class);
                startActivity(intent);
                finish();
            }
        }, DURACION_SPLASH);
    }
}
