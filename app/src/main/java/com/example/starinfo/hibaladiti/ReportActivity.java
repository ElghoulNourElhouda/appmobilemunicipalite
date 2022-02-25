package com.example.starinfo.hibaladiti;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ReportActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;

    String[] reportNames = {"مشاكل الطريق", "مشاكل إضاءة", "دكلاري "};
    int[] iconsReport = {R.drawable.iconevoirie,R.drawable.iconslumiere,R.drawable.declari};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(ReportActivity.this, reportNames, iconsReport);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), ReportVoirie.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), ReportLighting.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    String url1 = "https://play.google.com/store/apps/details?id=com.declari_poubelle.declaripoubelle&hl=fr";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url1));
                    startActivity(i);
                }




            }

        });
    }
}
