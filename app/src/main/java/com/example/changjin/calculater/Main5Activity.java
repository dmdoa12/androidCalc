package com.example.changjin.calculater;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class Main5Activity extends AppCompatActivity {
    Chronometer crono;
    CalendarView calendar;
    TimePicker timepick;
    Button bt1, bt2;
    RadioGroup rg;
    TextView textview;
    String str;
    String str2;
    boolean check = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("예약 프로그램");
        crono = (Chronometer) findViewById(R.id.chronometer2);
        textview = (TextView) findViewById(R.id.textView);

        setCalerendarView();
        setTimePicker();
        setButton();
        setRadioGroup();
    }

    void setTimePicker() {
        timepick = (TimePicker) findViewById(R.id.timePicker);
        timepick.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                str2 = hourOfDay + "시" + minute + "분";
            }
        });
    }

    void setCalerendarView() {
        calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                str = year + "년" + (month + 1) + "월" + dayOfMonth + "일";
            }
        });
    }


    void setButton() {
        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check==true)
                    return;
                check = true;
                crono.setBase(SystemClock.elapsedRealtime());
                crono.start();
                crono.setTextColor(Color.RED);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check == false) {
                    Toast.makeText(getApplicationContext(), "예약 시작 버튼을 누르세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (str == null) {
                    Toast.makeText(getApplicationContext(), "예약 날짜를 선택하셔야합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (str2 == null) {
                    Toast.makeText(getApplicationContext(), "예약 시간을 선택하셔야합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                check = false;
                crono.stop();
                crono.setTextColor(Color.BLUE);
                textview.setText(str + str2 + " 예약 됨");
            }
        });
    }

    void setRadioGroup() {
        rg = (RadioGroup) findViewById(R.id.raioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton) {
                    calendar.setVisibility(View.VISIBLE);
                    timepick.setVisibility(View.INVISIBLE);
                } else if (checkedId == R.id.radioButton2) {
                    calendar.setVisibility(View.INVISIBLE);
                    timepick.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
