package com.example.starinfo.hibaladiti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {
    Button button;
    String sub, mess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ((Button) findViewById(R.id.btnOK)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String to = ((EditText)findViewById(R.id.txtTo)).getText().toString();
                sub = ((EditText)findViewById(R.id.txtSubject)).getText().toString();
                mess = ((EditText)findViewById(R.id.txtMessage)).getText().toString();
                button = findViewById(R.id.btnOK);
                button.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences prefs = getSharedPreferences("session", MODE_PRIVATE);
                        String restoredText = prefs.getString("mail", null);

                        Firebase.sendMessage(ContactActivity.this,""+restoredText,"!!", sub, mess);
                    }
                });


                /*
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                mail.putExtra(Intent.EXTRA_SUBJECT, sub);
                mail.putExtra(Intent.EXTRA_TEXT, mess);
                mail.setType("message/rfc822");
                startActivity(Intent.createChooser(mail, "Send email via:"));
                */
            }
        });
    }
}
