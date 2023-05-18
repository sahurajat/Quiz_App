package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.IntSummaryStatistics;

public class ResultActivity extends AppCompatActivity {
    Button restart;
    TextView correct,wrong,finalans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        restart=(Button) findViewById(R.id.button6);
        correct=(TextView)findViewById(R.id.textView10);
        wrong=(TextView)findViewById(R.id.textView11);
        finalans=(TextView)findViewById(R.id.textView12) ;
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(ResultActivity.this,MainActivity.class);
                startActivity(in);


            }
        });
        Intent intent=getIntent();




        int correctAnswers = intent.getIntExtra("correct_answers", 0);
        correct.setText("correct_answers : "+correctAnswers);
        int wrongAnswers = intent.getIntExtra("wrong_answers", 0);
        wrong.setText("Wrong answers : "+wrongAnswers);
        int score = intent.getIntExtra("score", 0);
        finalans.setText("Final Score : "+score);


    }
}