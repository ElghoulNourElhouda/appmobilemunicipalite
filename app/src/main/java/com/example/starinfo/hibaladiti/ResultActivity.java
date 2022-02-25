package com.example.starinfo.hibaladiti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView ttt1,ttt2,ttt3,ttt4,ttt5,ttt6,ttt7;
    int score1=0;
    int score2=0;
    int score3=0;
    int score4=0;
    int score5=0;
    int score6=0;
    int score7=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView vscore=(TextView)findViewById(R.id.score);
        vscore.setText("Score : " + score1+score2+score3+score4+score5+score6+score7*100/7);
       Intent intent = getIntent();
        String val1 = intent.getStringExtra("val1");
        ttt1 =(TextView)findViewById(R.id.textView12);
        ttt1.setText(val1);
        if(val1.equals("راضي"))
        {
            score1=1;
            vscore.setText("Score : " + score1);
        }
        String val2 = intent.getStringExtra("val2");
        ttt2 =(TextView)findViewById(R.id.textView13);
        ttt2.setText(val2);
        if(val2.equals("راضي"))
        {
            score2=1;
            vscore.setText("Score : " + score2);
        }
        String val3 = intent.getStringExtra("val3");
        ttt3 =(TextView)findViewById(R.id.textView14);
        ttt3.setText(val3);
        if(val3.equals("راضي"))
        {
            score3=1;
            vscore.setText("Score : " + score3);
        }
        String val4 = intent.getStringExtra("val4");
        ttt4 =(TextView)findViewById(R.id.textView15);
        ttt4.setText(val4);
        if(val4.equals("راضي"))
        {
            score4=1;
            vscore.setText("Score : " + score4);
        }
        String val5 = intent.getStringExtra("val5");

        ttt5 =(TextView)findViewById(R.id.textView16);
        ttt5.setText(val5);
        if(val5.equals("راضي"))
        {
            score5=1;
            vscore.setText("Score : " + score5);
        }
        String val6 = intent.getStringExtra("val6");
        ttt6 =(TextView)findViewById(R.id.textView17);
        ttt6.setText(val6);
        if(val6.equals("راضي"))
        {
            score6=1;
            vscore.setText("Score : " + score6);
        }
        String val7 = intent.getStringExtra("val7");
        ttt7 =(TextView)findViewById(R.id.textView19);
        ttt7.setText(val7);
        if(val7.equals("راضي"))
        {
            score7=1;
            vscore.setText("Score : " + score7);
        }
        SharedPreferences prefs = getSharedPreferences("session", MODE_PRIVATE);
        String mail = prefs.getString("mail", null);


        Firebase.sendNote(""+mail, score1, score2, score3, score4, score5, score6, score7);

    }
}
