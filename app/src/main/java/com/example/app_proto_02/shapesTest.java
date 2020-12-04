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

public class shapesTest extends AppCompatActivity {

    int[] shapesImageList = new int[]{R.drawable.circletest, R.drawable.diamondtest, R.drawable.hearttest, R.drawable.ovaltest, R.drawable.rectangletest, R.drawable.squaretest, R.drawable.startest, R.drawable.triangletest};
    String[] shapesNameList = new String[]{"CIRCLE","DIAMOND","HEART","OVAL","RECTANGLE","SQUARE","STAR","TRIANGLE","PENTAGON","HEXAGON"};
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
        setContentView(R.layout.activity_shapes_test);

        initializeComponents();

        Random rand = new Random();
        for (int i = 0; i < shapesImageList.length; i++) {
            int randomIndexToSwap = rand.nextInt(shapesImageList.length);

            int temp = shapesImageList[randomIndexToSwap];
            shapesImageList[randomIndexToSwap] = shapesImageList[i];
            shapesImageList[i] = temp;

            String temp2 = shapesNameList[randomIndexToSwap];
            shapesNameList[randomIndexToSwap] = shapesNameList[i];
            shapesNameList[i] = temp2;
        }

        answerList.clear();
        currentQuestion = 1;
        score = 0;
        getQuestion();
    }

    public void onBackClick(View view)
    {
        startActivity(new Intent(shapesTest.this, shapesOptions.class));
    }

    public void onFirstShapeClick(View view)//users picks this answer
    {
        userAnswer = b1.getText().toString();
        checkAnswer(userAnswer);
    }

    public void onSecondShapeClick(View view)//users picks this answer
    {
        userAnswer = b2.getText().toString();
        checkAnswer(userAnswer);
    }

    public void onThirdShapeClick(View view)//users picks this answer
    {
        userAnswer = b3.getText().toString();
        checkAnswer(userAnswer);
    }

    public int randNum()//gets random number
    {
        int random = new Random().nextInt(3);
        return random;
    }

    public void getQuestion()//gets next answer and question
    {
        if (currentQuestion < shapesImageList.length + 1) {
            Random randAns = new Random();
            answerList.clear();

            question.setImageResource(shapesImageList[currentQuestion-1]);

            String ans = shapesNameList[currentQuestion-1];

            for (int i = 0; i < 3; i++) {
                while (answerList.contains(ans)){
                    answerPos = randAns.nextInt(shapesNameList.length);
                    ans = shapesNameList[answerPos];
                }
                answerList.add(ans);
            }

            for (int i = 0; i < buttonList.size(); i++){
                buttonList.get(i).setText(answerList.get(i));
            }

            int n = buttonList.size();

            for (int k = n-1; k > 0; k--) {

                // Pick a random index from 0 to k
                int j = randAns.nextInt(k);

                // Swap arr[i] with the element at random index
                String value = buttonList.get(k).getText().toString();
                buttonList.get(k).setText(buttonList.get(j).getText().toString());
                buttonList.get(j).setText(value);
            }

        } else {
            EndGame();
        }
    }

    public void EndGame(){
        Intent intent = new Intent(shapesTest.this, ScoreManager.class);
        intent.putExtra("Section", "Shapes");
        intent.putExtra("Game", "Quiz");
        intent.putExtra("UserScore", score);
        intent.putExtra("TotalScore", shapesImageList.length);
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
        b1 = findViewById(R.id.btnS1);
        b2 = findViewById(R.id.btnS2);
        b3 = findViewById(R.id.btnS3);

        buttonList.add(b1);
        buttonList.add(b2);
        buttonList.add(b3);
    }
}