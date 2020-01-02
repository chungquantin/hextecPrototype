package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class wnsound1 extends AppCompatActivity {

    Button btn_ps1;
    Button btn_ss1;

    MediaPlayer mediaPlayer;


    @Override
    protected void onDestroy () {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wnsound1);

        btn_ps1 = findViewById(R.id.btn_ps1);
        btn_ss1 = findViewById(R.id.btn_ss1);


        btn_ps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(wnsound1.this, R.raw.sound1);
                mediaPlayer.start();
            }
        });

        btn_ss1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            }
        });
    }
}