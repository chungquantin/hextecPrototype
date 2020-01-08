package com.example.coma;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    EditText nameInput,ageInput;
    Button backButton,confirmButton;
    RadioGroup genderRadioGroup;
    RadioButton male,female,other;
    String gender ="";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        configureBackButton();
        configureConfirmButton();
        configureGenderRadiogroup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void configureGenderRadiogroup(){
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        other = findViewById(R.id.otherGender);
        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.male:
                        Toast.makeText(InputActivity.this, "Male", Toast.LENGTH_SHORT).show();
                        gender = "Male";
                        break;
                    case R.id.female:
                        gender = "Female";
                        break;
                    case R.id.otherGender:
                        gender = "Other";
                        break;
                }
            }
        });
    }
    private void configureBackButton(){
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void configureConfirmButton(){
        confirmButton = findViewById(R.id.confirmButton);
        nameInput = findViewById(R.id.nameInput);
        ageInput = findViewById(R.id.ageInput);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= nameInput.getText().toString();
                String age = ageInput.getText().toString();
                if(!name.isEmpty() && !age.isEmpty() && !gender.isEmpty()) {
                    Toast.makeText(InputActivity.this, name + ": " + age +" - " + gender, Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(InputActivity.this, TabActivity.class));
                }
                else{
                    Toast.makeText(InputActivity.this, "Please fill in your information!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
