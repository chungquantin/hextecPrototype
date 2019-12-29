package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LauncherActivity extends AppCompatActivity {

    @Override
    public static final String TAG = LauncherActivity.class.getSimpleName();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);
        if (savedInstanceState == null)
        {
            Log.e(TAG, "Bug");
        }
        else
        {
            Log.e(TAG, "Hi");
        }
    }
}
