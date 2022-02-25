package com.example.starinfo.hibaladiti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ServiceActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;

    String[] reportNames = {"رخص بناء", "النظافة", "ترخيص الربط بالشبكات","الجباية المحلية" ,"وثائق إدارية", "عقود قران"};
    int[] iconsReport = {R.drawable.iconhome,R.drawable.icontrash,R.drawable.iconlamp,R.drawable.iconmoney,R.drawable.iconpaper,R.drawable.iconwedding};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(ServiceActivity.this, reportNames, iconsReport);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), PaperConstruction.class);
                    startActivityForResult(myIntent, 0);
                }

               if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Propreter.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), ReseauActivity.class);
                    startActivityForResult(myIntent, 0);
                }

               if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), CollectionLocal.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), AdministrativActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), WeddingActivity.class);
                    startActivityForResult(myIntent, 0);
                }

            }

        });
    }
}
