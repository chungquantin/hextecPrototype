package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class whitenoise extends AppCompatActivity {

    Button btn_s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whitenoise);


        btn_s1 = findViewById(R.id.btn_s1);
        btn_s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(whitenoise.this, wnsound1.class);
                startActivity(intent);
            }
        });




            }
}
