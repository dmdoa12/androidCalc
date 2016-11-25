package com.example.changjin.calculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    Button bt_selected;
    TextView tbx_pet;
    CheckBox cbx_start;
    LinearLayout laypet;
    RadioButton rad_dog,rad_cat,rad_rab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cbx_start = (CheckBox)findViewById(R.id.cbx_start);
        laypet = (LinearLayout)findViewById(R.id.lay_pet);
        tbx_pet = (TextView)findViewById(R.id.tbx_pet);
        rad_dog = (RadioButton)findViewById(R.id.btn_dog);
        rad_cat = (RadioButton)findViewById(R.id.btn_cat);
        rad_rab = (RadioButton)findViewById(R.id.btn_rabbit);
        bt_selected = (Button)findViewById(R.id.btn_selected);

        cbx_start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    laypet.setVisibility(View.VISIBLE);
                }
                else{
                    laypet.setVisibility(View.GONE);
                }
            }
        });

        setTitle("애완동물 고르기");
    }
}
