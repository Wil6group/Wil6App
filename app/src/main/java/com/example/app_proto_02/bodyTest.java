package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class bodyTest extends AppCompatActivity {

    int[] bodyImageList = new int[]{R.drawable.headtest, R.drawable.necktest, R.drawable.armtest, R.drawable.handtest, R.drawable.chesttest, R.drawable.stomachtest, R.drawable.legtest, R.drawable.kneetest, R.drawable.foottest};
    String[] bodyNameList = new String[]{"HEAD","NECK","ARM","HAND","CHEST","STOMACH","LEG","KNEE","FOOT","TOES","THIGH"};

    ImageView question;
    Button b1,b2,b3;
    int min = 0;
    int max = 7;
    int answerPos;
    String answerWord, userAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_test);

        initializeComponents();
        getQuestion();
    }

    public void onBackClick(View view)
    {
        startActivity(new Intent(bodyTest.this, bodyOptions.class));
    }

    public void onFirstClick(View view)//users picks this answer
    {
        userAnswer = b1.getText().toString();
        checkAnswer(userAnswer);
    }

    public void onSecondClick(View view)//users picks this answer
    {
        userAnswer = b2.getText().toString();
        checkAnswer(userAnswer);
    }

    public void onThirdClick(View view)//users picks this answer
    {
        userAnswer = b3.getText().toString();
        checkAnswer(userAnswer);
    }

    public int randNum()//gets random number
    {
        int random = new Random().nextInt((max - min) + 1) + min;
        return random;
    }

    public void getQuestion()//gets next answer and question
    {
        int randAns = new Random().nextInt((3 - 1) + 1) + 1;
        answerPos = randNum();
        answerWord = bodyNameList[answerPos];

        question.setImageResource(bodyImageList[answerPos]);

        if (randAns == 1)
        {
            b1.setText(bodyNameList[answerPos]);
            b2.setText(bodyNameList[answerPos+1]);
            b3.setText(bodyNameList[answerPos+2]);
        }else if (randAns == 2)
        {
            b1.setText(bodyNameList[answerPos+1]);
            b2.setText(bodyNameList[answerPos]);
            b3.setText(bodyNameList[answerPos+2]);
        }else
        {
            b1.setText(bodyNameList[answerPos+1]);
            b2.setText(bodyNameList[answerPos+2]);
            b3.setText(bodyNameList[answerPos]);
        }
    }

    public void checkAnswer(String ans)//validates users answer then displays another question if correct
    {
        if (ans.equals(bodyNameList[answerPos]))
        {
            Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show();
            getQuestion();
        }else
        {
            Toast.makeText(this, "Incorrect answer try again!", Toast.LENGTH_SHORT).show();
        }
    }

    public void initializeComponents()//initializes components
    {
        question = findViewById(R.id.imgQuestion);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
    }
}