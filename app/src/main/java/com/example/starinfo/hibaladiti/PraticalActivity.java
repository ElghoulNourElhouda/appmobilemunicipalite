package com.example.starinfo.hibaladiti;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PraticalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratical);
         ImageButton imface;
         imface=(ImageButton)findViewById(R.id.imageButton3);
         imface.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String url = "https://www.facebook.com/%D8%A8%D9%84%D8%AF%D9%8A%D8%A9-%D9%85%D8%AF%D9%86%D9%8A%D9%86-commune-de-M%C3%A9denine-1683958028396493/";
                 Intent i = new Intent(Intent.ACTION_VIEW);
                 i.setData(Uri.parse(url));
                 startActivity(i);

             }
         });


    }
}
