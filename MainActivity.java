package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Start,About;
    EditText Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        About=(Button)findViewById(R.id.button3);
        //when we click the about button it will show the developer page
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cretae object of the intent class

                Intent in1=new Intent(MainActivity.this,MainActivity2.class);
                //call the stART activity method
                startActivity(in1);
            }
        });

        //button start
        Start=(Button) findViewById(R.id.button);
        Name=(EditText) findViewById(R.id.editTextTextPersonName);


        //when we click the start button it will start the activity three and show the edit text name
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String ed_text=editText.getText().toString().trim();
                String ed_text=Name.getText().toString().trim();

                if(ed_text.isEmpty() ||ed_text.length() == 0 ||ed_text.equals("") ||ed_text == null)
                {
                    //Toast.makeText(getApplicationContext(), "firat enter test in edittext to send it to another activity", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this,"First Enter Your Name to Start a Quiz",Toast.LENGTH_SHORT).show();
                }
                else {
                    //Edittext is not empty
                    Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                    intent.putExtra("message key",ed_text);
                    //call the start activity
                    startActivity(intent);

                }
            }
        });


    }
}