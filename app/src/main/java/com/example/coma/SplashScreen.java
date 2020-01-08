package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.IpSecManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;


public class SplashScreen extends AppCompatActivity {

    TextView tipsText;
    public static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        tipsText = findViewById(R.id.tips);
        tipsText.setText("You should sleep until you wake up.");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainAcitivity = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(mainAcitivity);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
