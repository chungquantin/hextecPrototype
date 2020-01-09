package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FunctionSelection extends AppCompatActivity {

    TextView nameDisplay;

    ImageButton sleepRecButton, whiteNoiseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_selection);
        nameDisplay = findViewById(R.id.nameDisplay);
        nameDisplay.setText("Hi "+getIntent().getStringExtra("name")+","); //say hi to the name that the user gives
        sleepRecButton = findViewById(R.id.sleepRecommendationIcon);
        whiteNoiseButton = findViewById(R.id.whiteNoiseIcon);


        sleepRecButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionSelection.this,SleepRecommendation.class);
                startActivity(intent);
            }
        });
        whiteNoiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(FunctionSelection.this,WhiteNoise.class);
                startActivity(intent);*/
            }
        });

    }
}
