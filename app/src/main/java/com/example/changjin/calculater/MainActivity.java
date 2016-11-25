package com.example.changjin.calculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt_sum,bt_sub,bt_mul,bt_div,bt_mod;
    EditText et_num1, et_num2;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_num1 = (EditText)findViewById(R.id.tbx_num1) ;
        et_num2 = (EditText)findViewById(R.id.tbx_num2) ;
        tv_result = (TextView) findViewById(R.id.lbl_result);

        bt_sum = (Button)findViewById(R.id.btn_sum);
        bt_sub = (Button)findViewById(R.id.btn_sub);
        bt_mul = (Button)findViewById(R.id.btn_mul);
        bt_div = (Button)findViewById(R.id.btn_div);
        bt_mod = (Button)findViewById(R.id.btn_mod);

        bt_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc('+');
            }
        });

        bt_sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calc('-');
            }
        });
        bt_mul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calc('*');
            }
        });
        bt_div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calc('/');
            }
        });

        bt_mod.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calc('m');
            }
        });
    }

    public void calc(char op){
        int num1,num2;
        double result;
        num1 = Integer.parseInt(et_num1.getText().toString());
        num2 = Integer.parseInt(et_num2.getText().toString());
        if(op == '+'){
            result = num1+num2;
        }
        else if(op == '-'){
            result = num1-num2;
        }
        else if(op == '*'){
            result = num1*num2;
        }
        else if(op == '/'){
            if(num2==0){
                Toast.makeText(getApplicationContext(),"0으로 나눌수 없습니다",Toast.LENGTH_SHORT).show();
                return;
            }
            result = num1/(double)num2;
        }
        else{
            result = num1%(double)num2;
        }
        tv_result.setText("계산 결과 : "+result);
    }
}
