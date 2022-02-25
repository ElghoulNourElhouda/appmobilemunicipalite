package com.example.starinfo.hibaladiti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    TextView tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8;
    int i,j;
    Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
       tt1 =(TextView)findViewById(R.id.t1);
        tt2 =(TextView)findViewById(R.id.t2);
        tt3 =(TextView)findViewById(R.id.t3);
        tt4 =(TextView)findViewById(R.id.t4);
        tt5 =(TextView)findViewById(R.id.t5);
        tt6 =(TextView)findViewById(R.id.t6);
        tt7 =(TextView)findViewById(R.id.t7);
        //tt8 =(TextView)findViewById(R.id.t8);
        sub = (Button)findViewById(R.id.sub1);






        sub = (Button) findViewById(R.id.sub1);
        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //enter code here for your control and
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                RadioGroup group1= (RadioGroup) findViewById(R.id.g1);
                final RadioButton radio_red = (RadioButton)findViewById(group1.getCheckedRadioButtonId());
                final String val1 = radio_red.getText().toString();
                intent.putExtra("val1", val1);
                RadioGroup group3= (RadioGroup) findViewById(R.id.g3);
                final RadioButton radio_red1 = (RadioButton)findViewById(group3.getCheckedRadioButtonId());
                final String val2 = radio_red1.getText().toString();
                intent.putExtra("val2", val2);
                RadioGroup group4= (RadioGroup) findViewById(R.id.g4);
                final RadioButton radio_red2 = (RadioButton)findViewById(group4.getCheckedRadioButtonId());
                final String val3 = radio_red2.getText().toString();
                intent.putExtra("val3", val3);
                RadioGroup group5= (RadioGroup) findViewById(R.id.g5);
                final RadioButton radio_red3 = (RadioButton)findViewById(group5.getCheckedRadioButtonId());
                final String val4 = radio_red3.getText().toString();
                intent.putExtra("val4", val4);
                RadioGroup group6= (RadioGroup) findViewById(R.id.g6);
                final RadioButton radio_red4 = (RadioButton)findViewById(group6.getCheckedRadioButtonId());
                final String val5 = radio_red4.getText().toString();
                intent.putExtra("val5", val5);
                RadioGroup group7= (RadioGroup) findViewById(R.id.g7);
                final RadioButton radio_red5 = (RadioButton)findViewById(group7.getCheckedRadioButtonId());
                final String val6 = radio_red5.getText().toString();
                intent.putExtra("val6", val6);
                RadioGroup group8= (RadioGroup) findViewById(R.id.g8);
                final RadioButton radio_red6 = (RadioButton)findViewById(group8.getCheckedRadioButtonId());
                final String val7 = radio_red6.getText().toString();
                intent.putExtra("val7", val7);
                startActivity(intent);
            }
       });



    }
}
