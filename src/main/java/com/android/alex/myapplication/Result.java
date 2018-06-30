package com.android.alex.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wrong_answer);
    }
    public void returnQuiz(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);}
}
