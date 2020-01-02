package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;
    private Button btn_testm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name = "Coma";
        int year = 2019;
        Log.d("COMA", name + year);
        ArrayList<String> arrayName = new ArrayList<>();
        arrayName.add("Name1");
        arrayName.add("Name2");
        arrayName.add("Name3");
        for (int i = 0; i < arrayName.size(); i++) {
            Log.d("COMA", arrayName.get(i));
        }

        btn_testm = findViewById(R.id.btn_testm);
        btn_testm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, whitenoise.class);
                startActivity(intent);
            }
        });

    }
}
