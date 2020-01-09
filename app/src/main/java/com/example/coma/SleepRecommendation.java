package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SleepRecommendation extends AppCompatActivity {

    int sleepCycle=90;
    TextView timeSelect;
    Button best,good,neutral,bad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_recommendation);
        timeSelect = findViewById(R.id.timeSelect);
        best = findViewById(R.id.bestButton);
        good = findViewById(R.id.goodButton);
        neutral = findViewById(R.id.neutralButton);
        bad = findViewById(R.id.badButton);
        timeSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTime();
            }
        });
    }
    private void SelectTime(){
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                calendar.set(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH,hourOfDay,minute);
                String endTime = simpleDateFormat.format(calendar.getTime());
                timeSelect.setText(endTime);
                timeSelect.setTextSize(45);
                best.setVisibility(View.VISIBLE);
                good.setVisibility(View.VISIBLE);
                neutral.setVisibility(View.VISIBLE);
                bad.setVisibility(View.VISIBLE);

                calendar.add(Calendar.MINUTE,-6*sleepCycle); // 9 hours
                final String bestTime = simpleDateFormat.format(calendar.getTime());
                best.setText(bestTime);

                calendar.add(Calendar.MINUTE,sleepCycle); // 7.5
                final String goodTime = simpleDateFormat.format(calendar.getTime());
                good.setText(goodTime);

                calendar.add(Calendar.MINUTE,sleepCycle); // 6
                final String neutralTime = simpleDateFormat.format(calendar.getTime());
                neutral.setText(neutralTime);

                calendar.add(Calendar.MINUTE,sleepCycle); // 4.5
                final String badTime = simpleDateFormat.format(calendar.getTime());
                bad.setText(badTime);

                best.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SleepRecommendation.this,SleepTimer.class);
                        //intent.putExtra("sleeptime",bestTime);
                        startActivity(intent);
                    }
                });
                good.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SleepRecommendation.this,SleepTimer.class);
                        intent.putExtra("sleeptime",goodTime);
                        startActivity(intent);
                    }
                });
                neutral.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SleepRecommendation.this,SleepTimer.class);
                        intent.putExtra("sleeptime",neutralTime);
                        startActivity(intent);
                    }
                });
                bad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SleepRecommendation.this,SleepTimer.class);
                        intent.putExtra("sleeptime",badTime);
                        startActivity(intent);
                    }
                });
            }
        },hour,minute,true);
        timePickerDialog.show();
    }
}
