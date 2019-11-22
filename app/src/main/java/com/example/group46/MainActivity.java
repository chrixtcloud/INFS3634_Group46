package com.example.group46;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton quiz;
    ImageButton learnAbout;
    ImageButton company;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quiz = findViewById(R.id.quizIV);
        learnAbout = findViewById(R.id.learnaboutIV);
        company = findViewById(R.id.companyIV);


        quiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG, "onClick: Quiz Start button clicked");
                Intent intent = new Intent(MainActivity.this, QuizMain.class);
                startActivity(intent);
                Log.d(TAG, "onClick: Quiz intent launched");
            }

        });


        learnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: learn imageView clicked");
                Intent intent = new Intent(MainActivity.this, LearnAbout.class);
                startActivity(intent);
                Log.d(TAG, "onClick: LearnAbout intent launched");
            }

        });

        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: company imageView clicked");
                Intent intent = new Intent(MainActivity.this, CompanyActivity.class);
                startActivity(intent);
                Log.d(TAG, "onClick: company intent launched");
            }

        });



        }
    }




