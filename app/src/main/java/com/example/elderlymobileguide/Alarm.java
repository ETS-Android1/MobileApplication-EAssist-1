package com.example.elderlymobileguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Calendar;


public class Alarm extends AppCompatActivity{

    //EditText chooseTime;
    TimePicker timePickerClock;
    Calendar calendar;
    //Calendar Variables
    int currentMin;
    int currentHour;
    //Set Alarm Variables
    int hourSet;
    int minSet;
    //AM or PM
    String amPm;
    Button mSetAlarmButton;
    //Alarm Recurring variables
    CheckBox recurring;
    CheckBox mon;
    CheckBox tue;
    CheckBox wed;
    CheckBox thu;
    CheckBox fri;
    CheckBox sat;
    CheckBox sun;
    LinearLayout recurringOptions;
    //Tutorial Button
    Button tutorialBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        //Button initialization
        mSetAlarmButton = (Button) findViewById(R.id.alarm_enter_button);
        tutorialBtn = (Button) findViewById(R.id.tutorialBtn);

        //Getting actual time to put on the clock
        calendar = Calendar.getInstance();
        currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        currentMin = calendar.get(Calendar.MINUTE);

        //Initializing TimePicker variables and setting clock aesthetics
        timePickerClock = (TimePicker) findViewById(R.id.timePicker);
        timePickerClock.setIs24HourView(true);
        timePickerClock.setHour(currentHour);
        timePickerClock.setMinute(currentMin);

        //Alarm Recurring variable initializing
        recurring = findViewById(R.id.createalarm_recurring);
        mon = findViewById(R.id.createalarm_checkMon);
        tue = findViewById(R.id.createalarm_checkTue);
        wed = findViewById(R.id.createalarm_checkWed);
        thu = findViewById(R.id.createalarm_checkThu);
        fri = findViewById(R.id.createalarm_checkFri);
        sat = findViewById(R.id.createalarm_checkSat);
        sun = findViewById(R.id.createalarm_checkSun);
        recurringOptions = findViewById(R.id.createalarm_recurring_options);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.menuHome);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menuHome:
                        break;
                    case R.id.menuAccount:
                        startActivity(new Intent(getApplicationContext(),profile.class));
                        break;
                    case R.id.menuSettings:
                        startActivity(new Intent(getApplicationContext(),Settings.class));
                        break;
                }
                return false;
            }
        });


        //checks if recurring is checked to show repeating day options
        recurring.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    recurringOptions.setVisibility(View.VISIBLE);
                } else {
                    recurringOptions.setVisibility(View.GONE);
                }
            }
        });

        //When "setAlarm" button is pressed it starts the clock app(intent)
        mSetAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hourSet = timePickerClock.getHour();
                minSet = timePickerClock.getMinute();

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, hourSet);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,minSet);
                intent.putExtra(AlarmClock.EXTRA_DAYS,scheduleAlarms());

                if(hourSet <= 24 && minSet <= 60){
                    startActivity(intent);
                }
            }
        });

        tutorialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AlarmPopup.class));
            }
        });

    }

    //Passes time in the clock to used universally
    public void setTime(int hours, int minutes){
        hourSet = hours;
        minSet = minutes;
    }

    //Scheduling alarms
    public ArrayList<Integer> scheduleAlarms(){
        ArrayList<Integer> alarmDays = new ArrayList<Integer>();
        if(sun.isChecked()){
            alarmDays.add(1);
        }

        if (mon.isChecked()) {
            alarmDays.add(2);
        }

        if(tue.isChecked()){
            alarmDays.add(3);
        }

        if(wed.isChecked()){
            alarmDays.add(4);
        }

        if(thu.isChecked()){
            alarmDays.add(5);
        }

        if(fri.isChecked()){
            alarmDays.add(6);
        }

        if(sat.isChecked()){
            alarmDays.add(7);
        }

        return alarmDays;
    }



    //onResume set the current time to the clock
    @Override
    protected void onResume() {
        super.onResume();
        timePickerClock.setHour(currentHour);
        timePickerClock.setMinute(currentMin);
    }
}