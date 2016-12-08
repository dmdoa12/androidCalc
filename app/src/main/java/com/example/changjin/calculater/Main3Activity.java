package com.example.changjin.calculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Button bt_end,bt_clean;
    Switch swi_start;
    LinearLayout layand;
    RadioGroup rad_mas;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        swi_start = (Switch)findViewById(R.id.swi_start);
        rad_mas = (RadioGroup)findViewById(R.id.rad_master);
        layand = (LinearLayout)findViewById(R.id.lay_and);
        img = (ImageView)findViewById(R.id.and_view);
        bt_end = (Button)findViewById(R.id.btn_end);
        bt_clean = (Button)findViewById(R.id.btn_clean);

        swi_start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swi_start.isChecked()){
                    layand.setVisibility(View.VISIBLE);
                }
                else{
                    layand.setVisibility(View.GONE);
                }
            }
        });

        rad_mas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rad_mas.getCheckedRadioButtonId()==R.id.btn_jelly){
                    img.setImageResource(R.drawable.jelly);
                }
                else if(rad_mas.getCheckedRadioButtonId()==R.id.btn_kit){
                    img.setImageResource(R.drawable.kitkat);
                }
                else{
                    img.setImageResource(R.drawable.rollipop);
                }
            }
        });

        bt_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swi_start.setChecked(false);
                layand.setVisibility(View.INVISIBLE);
            }
        });

        setTitle("안드로이드 고르기");
    }
}
