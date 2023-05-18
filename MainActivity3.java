package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity3 extends AppCompatActivity {
    TextView name,qs;
    Button submit,quit;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String question[]={"which method can be defined only once in a program?",
            "which keyword is used by method to refer to the object that invoked it?",
            "which of these access specifers can be used for an interface?",
            "which of the following is correct way of importing an entire package 'pkg'?",
            "which is the return type of constructors?"};
    String answer[]={"main method","this","public","importpkg.*","none of the mentioned"};
    String opt[]={"finalize method","main method","static method","private method",
            "import","this","catch","abstract",
            "public","protected","private","all of the mentioned",
            "Importpkg.","importpkg.*","Importpkg.*","importpkg.",
            "int","float","void","none of the mentioned"};
    int flag=0;
    public static  int marks=0,correct=0,wrong=0,Score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        name=(TextView) findViewById(R.id.textView7);

        Intent intent=getIntent();
        String str=intent.getStringExtra("message key");
        name.setText(" Hello "+str);


        final TextView  score=(TextView)findViewById(R.id.textView8);

        submit=(Button) findViewById(R.id.button4);
        quit=(Button) findViewById(R.id.button5);
        qs=(TextView)findViewById(R.id.textView9);

        radio_g=(RadioGroup) findViewById(R.id.radioGroup2);

        rb1=(RadioButton) findViewById(R.id.radioButton3);
        rb2=(RadioButton) findViewById(R.id.radioButton4);
        rb3=(RadioButton) findViewById(R.id.radioButton5);
        rb4=(RadioButton) findViewById(R.id.radioButton6);

         submit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {


                 if(radio_g.getCheckedRadioButtonId()==-1)
                 {
                     Toast.makeText(MainActivity3.this, "Please select one choice", Toast.LENGTH_SHORT).show();

                     return;
                 }


                 RadioButton uans=(RadioButton) findViewById(radio_g.getCheckedRadioButtonId());

                 String ansText=uans.getText().toString();

                 if(ansText.equals(answer[flag]))
                 {
                     correct++;


                     Toast.makeText(MainActivity3.this, "Correct", Toast.LENGTH_SHORT).show();

                 }
                 else
                 {
                     wrong++;


                     Toast.makeText(MainActivity3.this, "Wrong", Toast.LENGTH_SHORT).show();
                 }
                 flag++;

                 if(score != null)
                 {
                     score.setText("Your Score "+correct);
                 }


                 if(flag < question.length)
                 {
                    qs.setText(question[flag]);
                     rb1.setText(opt[flag*4]);
                     rb2.setText(opt[flag*4+1]);
                     rb3.setText(opt[flag*4 + 2]);
                     rb4.setText(opt[flag*4 +3]);


                 }
                 else{
                     marks=correct;
                     Intent in4=new Intent(MainActivity3.this, ResultActivity.class);

                     in4.putExtra("correct_answers", correct);
                     in4.putExtra("wrong_answers", wrong);
                     in4.putExtra("score", correct);

                     startActivity(in4);
                     resetScore();
                 }
                 radio_g.clearCheck();




             }

         });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View view) {
                 Intent in2=new Intent(MainActivity3.this,ResultActivity.class);

                 startActivity(in2);
             }
         });



    }
    private void resetScore() {
        marks = 0;
        correct = 0;
        wrong = 0;
    }
    }