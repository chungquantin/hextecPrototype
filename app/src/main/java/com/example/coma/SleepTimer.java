package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SleepTimer extends AppCompatActivity {


    String sleepTime = getIntent().getStringExtra("sleeptime");
    TextView wakeTimeLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_timer);
        wakeTimeLeft = findViewById(R.id.waketimeLeft);
        wakeTimeLeft.setText(sleepTime);
    }
}
