package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class animalTest extends AppCompatActivity {

    int[] animalImageList = new int[]{R.drawable.bee, R.drawable.bird, R.drawable.cat, R.drawable.chicken, R.drawable.dog, R.drawable.fish, R.drawable.sheep, R.drawable.butterfly};
    String[] animalNameList = new String[]{"BEE","BIRD","CAT","CHICKEN","DOG","FISH","SHEEP","BUTTERFLY","GOAT","LION"};

    ImageView question;
    Button b1,b2,b3;
    int min = 0;
    int max = 7;
    int answerPos;
    String answerWord, userAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_test);

        initializeComponents();
        getQuestion();
    }

    public void onBackClick(View view)
    {
        startActivity(new Intent(animalTest.this, animalsOptions.class));
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
        answerWord = animalNameList[answerPos];

        question.setImageResource(animalImageList[answerPos]);

        if (randAns == 1)
        {
            b1.setText(animalNameList[answerPos]);
            b2.setText(animalNameList[answerPos+1]);
            b3.setText(animalNameList[answerPos+2]);
        }else if (randAns == 2)
        {
            b1.setText(animalNameList[answerPos+1]);
            b2.setText(animalNameList[answerPos]);
            b3.setText(animalNameList[answerPos+2]);
        }else
            {
                b1.setText(animalNameList[answerPos+1]);
                b2.setText(animalNameList[answerPos+2]);
                b3.setText(animalNameList[answerPos]);
            }
    }

    public void checkAnswer(String ans)//validates users answer then displays another question if correct
    {
        if (ans.equals(animalNameList[answerPos]))
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