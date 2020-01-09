package com.example.coma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SleepRecommendation extends AppCompatActivity {

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
                String end_time = simpleDateFormat.format(calendar.getTime());
                best.setText(end_time);
                timeSelect.setText(end_time);
                timeSelect.setTextSize(45);
            }
        },hour,minute,true);
        timePickerDialog.show();
    }
}
