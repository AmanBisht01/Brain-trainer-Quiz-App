package com.aman.braintrainerquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button start,btn0,btn1,btn2,btn3;
    TextView question;
    ArrayList<Integer> answers= new ArrayList<>();
    int locateOfCorrentAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        question=findViewById(R.id.question);
        btn0=findViewById(R.id.ans0);
        btn1=findViewById(R.id.ans1);
        btn2=findViewById(R.id.ans2);
        btn3=findViewById(R.id.ans3);


        Random rand=new Random();

        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        question.setText(Integer.toString(a)+ "+" +Integer.toString(b));
        locateOfCorrentAns=rand.nextInt(4);
        int incorrect;

        for (int i=0;i<4;i++){
            if(i==locateOfCorrentAns){
                answers.add(a+b);
            }else {
                incorrect=rand.nextInt(41);
                while(incorrect==a+b) {

                    incorrect=rand.nextInt(41);
                }
                    answers.add(incorrect);
            }
        }

        btn0.setText(Integer.toString(answers.get(0)));
        btn1.setText(Integer.toString(answers.get(1)));
        btn2.setText(Integer.toString(answers.get(2)));
        btn3.setText(Integer.toString(answers.get(3)));


    }

    public void start(View view) {
        start.setVisibility(view.INVISIBLE);
    }

    public void chooseAns(View view) {

        if (view.getTag().toString().equals(Integer.toString(locateOfCorrentAns))){

            // TODO
        }


    }
}