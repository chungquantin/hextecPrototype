package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;
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

    }
}
