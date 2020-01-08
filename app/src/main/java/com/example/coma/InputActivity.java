package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        configureBackButton();
        configureConfirmButton();
    }
    private void configureBackButton(){
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void configureConfirmButton(){
        Button confirmButton = findViewById(R.id.confirmButton);
        final EditText nameInput = findViewById(R.id.nameInput);
        final EditText ageInput = findViewById(R.id.ageInput);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameInput.getText().toString();
                String age = ageInput.getText().toString();
                Toast.makeText(InputActivity.this,name+": "+age,Toast.LENGTH_SHORT).show();
                /*startActivity(new Intent(InputActivity.this,.class));*/
            }
        });
    }
}
