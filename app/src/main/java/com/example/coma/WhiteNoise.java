package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class WhiteNoise extends AppCompatActivity {
    boolean show = false;
    MediaPlayer waterfallSound,birdSound,rainSound;
    ImageView showButton, waterfall, bird, rain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_noise);
        showButton = findViewById(R.id.showButton);
        waterfall = findViewById(R.id.waterfall);
        bird = findViewById(R.id.bird);
        rain = findViewById(R.id.rain);
        waterfallSound = MediaPlayer.create(WhiteNoise.this,R.raw.waterfall);
        birdSound = MediaPlayer.create(WhiteNoise.this,R.raw.bird);
        rainSound = MediaPlayer.create(WhiteNoise.this,R.raw.rain);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOptions();
            }
        });
        waterfall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(waterfallSound.isPlaying()) {
                    waterfallSound.pause();
                }
                else{
                    waterfallSound.start();
                }
            }
        });
        rain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rainSound.isPlaying()) {
                    rainSound.pause();
                }
                else{
                    rainSound.start();
                }
            }
        });
        bird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(birdSound.isPlaying()) {
                    birdSound.pause();
                }
                else{
                    birdSound.start();
                }
            }
        });
    }

    private void ShowOptions() {
        if(!show) {
            waterfall.setVisibility(View.VISIBLE);
            bird.setVisibility(View.VISIBLE);
            rain.setVisibility(View.VISIBLE);
            Toast.makeText(WhiteNoise.this, "Choose a sound to play", Toast.LENGTH_SHORT).show();
        }
        else{
            waterfall.setVisibility(View.INVISIBLE);
            bird.setVisibility(View.INVISIBLE);
            rain.setVisibility(View.INVISIBLE);
        }
        show = !show;
    }
}

