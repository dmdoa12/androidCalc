package com.example.changjin.calculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    Button bt_selected;
    CheckBox cbx_start;
    LinearLayout laypet;
    RadioGroup rad_mas;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cbx_start = (CheckBox)findViewById(R.id.cbx_start);
        laypet = (LinearLayout)findViewById(R.id.lay_pet);
        rad_mas = (RadioGroup)findViewById(R.id.rad_master);
        bt_selected = (Button)findViewById(R.id.btn_selected);
        img = (ImageView) findViewById(R.id.img_view);

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

        bt_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rad_mas.getCheckedRadioButtonId()==R.id.btn_dog){
                    img.setImageResource(R.drawable.dog);
                }
                else if(rad_mas.getCheckedRadioButtonId()==R.id.btn_cat){
                    img.setImageResource(R.drawable.cat);
                }
                else{
                    img.setImageResource(R.drawable.rabbit);
                }
            }
        });


        setTitle("애완동물 고르기");
    }
}
