package com.example.starinfo.hibaladiti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    CardView bankCard,reportCard,serviceCard,buildingCard,contactCard,familyCard,praticalId,quizId,jamid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //bankCard =(CardView)findViewById(R.id.bankcardId);
        reportCard =(CardView)findViewById(R.id.ReportId);
        serviceCard =(CardView)findViewById(R.id.serviceId);
        //buildingCard=(CardView)findViewById(R.id.buildingId);
        contactCard =(CardView)findViewById(R.id.contactId);
        familyCard =(CardView)findViewById(R.id.PortalId);
        praticalId =(CardView)findViewById(R.id.practicalinformationId);
        quizId =(CardView)findViewById(R.id.QuizzId);
        jamid=(CardView)findViewById(R.id.jammId);

        //bankCard.setOnClickListener(this);
        reportCard.setOnClickListener(this);
        serviceCard.setOnClickListener(this);
        //buildingCard.setOnClickListener(this);
        contactCard.setOnClickListener(this);
        familyCard.setOnClickListener(this);
        praticalId.setOnClickListener(this);
        quizId.setOnClickListener(this);
        jamid.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId())
        {
            /*case R.id.bankcardId:i = new Intent(this,EventActivity.class);
            startActivity(i);
            break;*/
            case R.id.ReportId:i= new Intent(this,ReportActivity.class);
            startActivity(i);
                break;
            case R.id.serviceId: i= new Intent(this,ServiceActivity.class);
            startActivity(i);
            break;
            case R.id.practicalinformationId: i= new Intent(this,PraticalActivity.class);
                startActivity(i);
                break;
            case R.id.contactId:i= new Intent(this,ContactActivity.class);
                startActivity(i);
                break;
           /* case R.id.buildingId:i= new Intent(this,BuildingActivity.class);
                startActivity(i);
            break;*/
            case R.id.PortalId:i= new Intent(this,FamilyActivity.class);
                startActivity(i);
            break;
            case R.id.QuizzId:i= new Intent(this,QuizActivity.class);
                startActivity(i);
                break;
            case R.id.jammId:i= new Intent(this,JamActivity.class);
                startActivity(i);
                break;
            default:break;


        }


    }
}
