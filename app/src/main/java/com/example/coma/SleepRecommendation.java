package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SleepRecommendation extends AppCompatActivity {

    int sleepCycle=90;
    TextView timeSelect,timer,reminder,tip,sleepLength;
    Button best,good,neutral,bad;
    String bestTime,goodTime,neutralTime,badTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_recommendation);
        sleepLength= findViewById(R.id.sleepLength);
        timeSelect = findViewById(R.id.timeSelect);
        best = findViewById(R.id.bestButton);
        good = findViewById(R.id.goodButton);
        neutral = findViewById(R.id.neutralButton);
        bad = findViewById(R.id.badButton);
        timer = findViewById(R.id.timer);
        reminder = findViewById(R.id.reminder);
        tip = findViewById(R.id.tip2);
        timeSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTime();
            }
        });
    }
    private void ShowTimer(){
        reminder.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        tip.setVisibility(View.VISIBLE);
        sleepLength.setVisibility(View.VISIBLE);
    }
    private void SelectTime(){
        final Calendar calendar = Calendar.getInstance();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        final String startTime = simpleDateFormat.format(calendar.getTime());
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH,hourOfDay,minute);
                final String endTime = simpleDateFormat.format(calendar.getTime());
                timeSelect.setText(endTime);
                timeSelect.setTextSize(45);
                best.setVisibility(View.VISIBLE);
                good.setVisibility(View.VISIBLE);
                neutral.setVisibility(View.VISIBLE);
                bad.setVisibility(View.VISIBLE);

                calendar.add(Calendar.MINUTE,-6*sleepCycle); // 9 hours
                bestTime = simpleDateFormat.format(calendar.getTime());
                best.setText(bestTime);

                calendar.add(Calendar.MINUTE,sleepCycle); // 7.5
                goodTime = simpleDateFormat.format(calendar.getTime());
                good.setText(goodTime);

                calendar.add(Calendar.MINUTE,sleepCycle); // 6
                neutralTime = simpleDateFormat.format(calendar.getTime());
                neutral.setText(neutralTime);

                calendar.add(Calendar.MINUTE,sleepCycle); // 4.5
                badTime = simpleDateFormat.format(calendar.getTime());
                bad.setText(badTime);

                best.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShowTimer();
                        timer.setText(bestTime);
                        sleepLength.setText("6 SLEEP CYCLE - 9 HOURS");
                        sleepLength.setTextColor(Color.GREEN);
                    }
                });
                good.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShowTimer();
                        timer.setText(goodTime);
                        sleepLength.setText("5 SLEEP CYCLE - 7.5 HOURS");
                        sleepLength.setTextColor(Color.GREEN);
                    }
                });
                neutral.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShowTimer();
                        timer.setText(neutralTime);
                        sleepLength.setText("4 SLEEP CYCLE - 6 HOURS");
                        sleepLength.setTextColor(Color.YELLOW);
                    }
                });
                bad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShowTimer();
                        timer.setText(badTime);
                        sleepLength.setText("3 SLEEP CYCLE - 4.5 HOURS");
                        sleepLength.setTextColor(Color.RED);
                    }
                });


            }
        },hour,minute,true);
        timePickerDialog.show();
    }
}
