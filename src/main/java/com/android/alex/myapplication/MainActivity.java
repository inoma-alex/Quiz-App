package com.android.alex.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int score=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);



        String string= getString(R.string.option1);

//        Button next = findViewById(R.id.next);
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View q1 = findViewById(R.id.Q1);
//                q1.setVisibility(View.GONE);
//                View q2 = findViewById(R.id.Q2);
//                q2.setVisibility(View.VISIBLE);
//
//            }
//
//        });
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View q1 = findViewById(R.id.Q1);
//                q1.setVisibility(View.GONE);
//                View q2 = findViewById(R.id.Q2);
//                q2.setVisibility(View.GONE);
//                View q3 = findViewById(R.id.Q3);
//                q3.setVisibility(View.VISIBLE);
//
//            }
//
//        });


    }
    public void openApp(View view){
        setContentView(R.layout.activity_main);
    }

    private void advice(int score) {
        TextView getAdvice = (TextView) findViewById(R.id.advice);
        String myAdvice = "";

        if (score == 100) {
            myAdvice = "That's superb, you got a perfect score" + "\nAren't you smart!";
        }
        else if(score > 70 && score < 100) {
            myAdvice = "You got an A" + "\n Good job!";

        }
        else if (score >= 50 && score < 70) {
            myAdvice = "Nice going, you got a C" + "\nBetter luck next time!";

        }
        else if (score < 39) {
            myAdvice = "Sorry, you failed" + "\n Please try Again!";

        }

        getAdvice.setText(myAdvice);
    }

    public void submitAnswers(View view) {
        RadioButton radioButton = (RadioButton) findViewById(R.id.q1_answer);
        boolean radio= radioButton.isChecked();

        RadioButton radioButton2 = (RadioButton) findViewById(R.id.q2_answer);
        boolean radio2= radioButton2.isChecked();

        RadioButton radioButton3 = (RadioButton) findViewById(R.id.q3_answer);
        boolean radio3= radioButton3.isChecked();

        RadioButton radioButton4 = (RadioButton) findViewById(R.id.q4_answer);
        boolean radio4= radioButton4.isChecked();


        setContentView(R.layout.result);


        score(radio,radio2,radio3,radio4);
        if(score==100) {
            Button correction = findViewById(R.id.correction);
            correction.setText("Return to quiz");

        }
        advice(score);
    }

//    public void q1_radioButton(boolean radio){
//
//    if(radio) {
//        setContentView(R.layout.result);
//
//    } else {
//        TextView text= new TextView(this);
//        text.setText("hello");
//        setContentView(text);
//    }
//
//    }



    private void score(boolean radio, boolean radio2, boolean radio3, boolean radio4){
        TextView finalScore= (TextView) findViewById(R.id.score);

        if(radio) {
            score += 25;

        } else {
             score += 0 ;

        }
        if (radio2) {
            score += 25;
        } else {

            score += 0;
        }
        if (radio3) {
            score += 25;
        } else {

            score += 0;
        }
        if (radio4) {
            score += 25;
        } else {

            score += 0;
        }
        String myScore = score+ "%";
        finalScore.setText(myScore);

    }

    public void submitCorrection(View view) {
        if (score<100){
            Intent intent = new Intent(this, Result.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
            score=0;
        }
    }

}

