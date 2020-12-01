package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MathGame extends AppCompatActivity {
                                                  //Score counter
                                                  //Gamification

    public TextView operation;
    public TextView question;
    public EditText answer;
    public  int correctanswer;
    String mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
        operation=(TextView)findViewById(R.id.OperationTxt);
        mode = getIntent().getStringExtra("extra");
        operation.setText(mode);
        calculationoperation(mode);
    }

    public void calculationoperation(String operation){

        if(operation.equals("Addition")){
            int a = new Random().nextInt((100));
            int b = new Random().nextInt((100));
            String questio = a+" + "+b;
            question = (TextView) findViewById(R.id.QuestionTxt);
            question.setText(questio);
            correctanswer = a+b;

        }


        if(operation.equals("Subtraction")){
            int a = new Random().nextInt((100));
            int b = new Random().nextInt((100));
            String questio = a+" - "+b;
            question = (TextView) findViewById(R.id.QuestionTxt);
            question.setText(questio);
            correctanswer =a-b;

        }

        if(operation.equals("Division")){
            int a = new Random().nextInt((100));
            int b = new Random().nextInt((10));
            int c = a*b;
            String questio = c+" / "+a;
            question = (TextView) findViewById(R.id.QuestionTxt);
            question.setText(questio);
            correctanswer =c/a;

        }

        if(operation.equals("Multiplication")){
            int a = new Random().nextInt((12));
            int b = new Random().nextInt((12));
            String questio = a+" x "+b;
            question = (TextView) findViewById(R.id.QuestionTxt);
            question.setText(questio);
            correctanswer =a*b;


        }
    }

    public void ValidateAnswer(View v){
        answer =  (EditText) findViewById(R.id.AnswerTxt);
        String userasnwer =answer.getText().toString();
        if(Integer.parseInt(userasnwer) ==correctanswer){
            Toast.makeText(this,"Well done this is correct",Toast.LENGTH_LONG).show();
            calculationoperation(mode);
            answer.setText("");
        }

        else{
            Toast.makeText(this,"Wrong try again",Toast.LENGTH_LONG).show();
        }
    }

    public void onBackClick(View view)
    {
        startActivity(new Intent(MathGame.this, numbersOptions.class));
    }
}