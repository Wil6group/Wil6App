package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class animalTest extends AppCompatActivity {

    int[] animalImageList = new int[]{R.drawable.bee, R.drawable.bird, R.drawable.cat, R.drawable.chicken, R.drawable.dog, R.drawable.fish, R.drawable.sheep, R.drawable.butterfly};
    String[] animalNameList = new String[]{"BEE","BIRD","CAT","CHICKEN","DOG","FISH","SHEEP","BUTTERFLY","GOAT","LION"};
    List<Button> buttonList = new ArrayList<>();
    List<String> answerList = new ArrayList<>();

    ImageView question;
    Button b1,b2,b3;
    int min = 0;
    int max = 7;
    int answerPos;
    String answerWord, userAnswer;

    int currentQuestion, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_test);

        initializeComponents();

        Random rand = new Random();
        for (int i = 0; i < animalImageList.length; i++) {
            int randomIndexToSwap = rand.nextInt(animalImageList.length);

            int temp = animalImageList[randomIndexToSwap];
            animalImageList[randomIndexToSwap] = animalImageList[i];
            animalImageList[i] = temp;

            String temp2 = animalNameList[randomIndexToSwap];
            animalNameList[randomIndexToSwap] = animalNameList[i];
            animalNameList[i] = temp2;
        }

        answerList.clear();
        currentQuestion = 1;
        score = 0;
        getQuestion();
    }

    public void onBackClick(View view)
    {
        startActivity(new Intent(animalTest.this, animalsOptions.class));
    }

    public void onFirstAniClick(View view)//users picks this answer
    {
        userAnswer = b1.getText().toString();
        checkAnswer(userAnswer);
    }

    public void onSecondAniClick(View view)//users picks this answer
    {
        userAnswer = b2.getText().toString();
        checkAnswer(userAnswer);
    }

    public void onThirdAniClick(View view)//users picks this answer
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
        if (currentQuestion < animalImageList.length + 1) {
            Random randAns = new Random();
            answerList.clear();

            question.setImageResource(animalImageList[currentQuestion-1]);

            String ans = animalNameList[currentQuestion-1];
            for (int i = 0; i < 3; i++) {
                while (answerList.contains(ans)){
                    answerPos = randAns.nextInt(animalNameList.length);
                    ans = animalNameList[answerPos];
                }
                answerList.add(ans);
            }

            for (int i = 0; i < buttonList.size(); i++){
                buttonList.get(i).setText(answerList.get(i));
            }

            for (int z = 0; z < 2; z++) {
                int n = buttonList.size();

                for (int k = n-1; k > 0; k--) {

                    // Pick a random index from 0 to k
                    int j = randAns.nextInt(k);

                    // Swap arr[i] with the element at random index
                    String value = buttonList.get(k).getText().toString();
                    buttonList.get(k).setText(buttonList.get(j).getText().toString());
                    buttonList.get(j).setText(value);
                }
            }

        } else {
            EndGame();
        }
    }

    public void EndGame(){
        Intent intent = new Intent(animalTest.this, ScoreManager.class);
        intent.putExtra("Section", "Animals");
        intent.putExtra("Game", "Quiz");
        intent.putExtra("UserScore", score);
        intent.putExtra("TotalScore", animalImageList.length);
        startActivity(intent);
    }


    public void checkAnswer(String ans)//validates users answer then displays another question if correct
    {
        if (ans.equalsIgnoreCase(answerList.get(0).trim()))
        {
            Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show();
            score++;
        } else
        {
            Toast.makeText(this, "Incorrect answer try again!", Toast.LENGTH_SHORT).show();
        }

        currentQuestion++;
        getQuestion();
    }

    public void initializeComponents()//initializes components
    {
        question = findViewById(R.id.imgQuestion);
        b1 = findViewById(R.id.btnA1);
        b2 = findViewById(R.id.btnA2);
        b3 = findViewById(R.id.btnA3);

        buttonList.add(b1);
        buttonList.add(b2);
        buttonList.add(b3);
    }
}