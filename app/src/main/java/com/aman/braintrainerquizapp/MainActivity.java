package com.aman.braintrainerquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button start,btn0,btn1,btn2,btn3,playagain;
    TextView question,result;
    ArrayList<Integer> answers= new ArrayList<>();
    int locateOfCorrentAns,score=0;
    int numberOfQuestion=0;
    TextView points;
    TextView timer;
    RelativeLayout game;

    public void playAgain(View view){
         score=0;
         numberOfQuestion=0;
        timer.setText("30s");
        points.setText("0/0");
        result.setText("");
        playagain.setVisibility(View.INVISIBLE);
        generateQuestion();

        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(millisUntilFinished / 1000 + " s");

            }

            @Override
            public void onFinish() {
                timer.setText("0s");
                result.setText("Your Score is "+Integer.toString(score)+"/"+Integer.toString(numberOfQuestion));
                playagain.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void generateQuestion(){
        Random rand=new Random();

        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        question.setText(Integer.toString(a)+ "+" +Integer.toString(b));
        locateOfCorrentAns=rand.nextInt(4);
        answers.clear();

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
        result=findViewById(R.id.result);
        points=findViewById(R.id.scoreText);
        timer=findViewById(R.id.timerText);
        playagain=findViewById(R.id.playAgain);
        game=findViewById(R.id.gameRelativeLayout);

    }

    public void start(View view) {
        start.setVisibility(view.INVISIBLE);
        game.setVisibility(RelativeLayout.VISIBLE);
        playAgain(playagain);
    }

    public void chooseAns(View view) {

        if (view.getTag().toString().equals(Integer.toString(locateOfCorrentAns))){
            score++;
            result.setText("Corrext!");
        }else{
            result.setText("Wrong!");
        }
        numberOfQuestion++;
        points.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestion));
        generateQuestion();

    }
}