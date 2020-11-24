package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class colourTest extends AppCompatActivity {

    int[] colourImageList = new int[]{R.drawable.bluetest, R.drawable.redtest, R.drawable.greentest, R.drawable.yellowtest, R.drawable.orangetest, R.drawable.pinktest, R.drawable.purpletest, R.drawable.blacktest,R.drawable.greytest, R.drawable.browntest};
    String[] colourNameList = new String[]{"BLUE","RED","GREEN","YELLOW","ORANGE","PINK","PURPLE","BLACK","GREY", "BROWN","GOLD","SILVER"};

    ImageView question;
    Button b1,b2,b3;
    int min = 0;
    int max = 9;
    int answerPos;
    String answerWord, userAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_test);

        initializeComponents();
        getQuestion();
    }

    public void onBackClick(View view)
    {
        startActivity(new Intent(colourTest.this, coloursOptions.class));
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
        answerWord = colourNameList[answerPos];

        question.setImageResource(colourImageList[answerPos]);

        if (randAns == 1)
        {
            b1.setText(colourNameList[answerPos]);
            b2.setText(colourNameList[answerPos+1]);
            b3.setText(colourNameList[answerPos+2]);
        }else if (randAns == 2)
        {
            b1.setText(colourNameList[answerPos+1]);
            b2.setText(colourNameList[answerPos]);
            b3.setText(colourNameList[answerPos+2]);
        }else
        {
            b1.setText(colourNameList[answerPos+1]);
            b2.setText(colourNameList[answerPos+2]);
            b3.setText(colourNameList[answerPos]);
        }
    }

    public void checkAnswer(String ans)//validates users answer then displays another question if correct
    {
        if (ans.equals(colourNameList[answerPos]))
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
        b1 = findViewById(R.id.btn1Colour);
        b2 = findViewById(R.id.btn2Colour);
        b3 = findViewById(R.id.btn3Colour);
    }
}