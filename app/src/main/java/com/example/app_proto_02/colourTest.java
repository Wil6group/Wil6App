package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class colourTest extends AppCompatActivity {

    int[] colourImageList = new int[]{R.drawable.bluetest, R.drawable.redtest, R.drawable.greentest, R.drawable.yellowtest, R.drawable.orangetest, R.drawable.pinktest, R.drawable.purpletest, R.drawable.blacktest,R.drawable.greytest, R.drawable.browntest};
    String[] colourNameList = new String[]{"BLUE","RED","GREEN","YELLOW","ORANGE","PINK","PURPLE","BLACK","GREY", "BROWN","GOLD","SILVER"};
    List<Button> buttonList = new ArrayList<>();
    List<String> answerList = new ArrayList<>();

    ImageView question;
    Button b1,b2,b3;
    int min = 0;
    int max = 9;
    int answerPos;
    String answerWord, userAnswer;

    int currentQuestion, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_test);

        initializeComponents();

        Random rand = new Random();
        for (int i = 0; i < colourImageList.length; i++) {
            int randomIndexToSwap = rand.nextInt(colourImageList.length);

            int temp = colourImageList[randomIndexToSwap];
            colourImageList[randomIndexToSwap] = colourImageList[i];
            colourImageList[i] = temp;

            String temp2 = colourNameList[randomIndexToSwap];
            colourNameList[randomIndexToSwap] = colourNameList[i];
            colourNameList[i] = temp2;
        }

        answerList.clear();
        currentQuestion = 1;
        score = 0;
        getQuestion();
    }

    public void onBackClick(View view)
    {
        startActivity(new Intent(colourTest.this, coloursOptions.class));
    }

    public void onFirstColClick(View view)//users picks this answer
    {
        userAnswer = b1.getText().toString();
        checkAnswer(userAnswer);
    }

    public void onSecondColClick(View view)//users picks this answer
    {
        userAnswer = b2.getText().toString();
        checkAnswer(userAnswer);
    }

    public void onThirdColClick(View view)//users picks this answer
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
        if (currentQuestion < colourImageList.length + 1) {
            Random randAns = new Random();
            answerList.clear();

            question.setImageResource(colourImageList[currentQuestion-1]);

            String ans = colourNameList[currentQuestion-1];
            for (int i = 0; i < 3; i++) {
                while (answerList.contains(ans)){
                    answerPos = randAns.nextInt(colourNameList.length);
                    ans = colourNameList[answerPos];
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
        Intent intent = new Intent(colourTest.this, ScoreManager.class);
        intent.putExtra("Section", "Colours");
        intent.putExtra("Game", "Quiz");
        intent.putExtra("UserScore", score);
        intent.putExtra("TotalScore", colourImageList.length);
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
        b1 = findViewById(R.id.btnC1);
        b2 = findViewById(R.id.btnC2);
        b3 = findViewById(R.id.btnC3);

        buttonList.add(b1);
        buttonList.add(b2);
        buttonList.add(b3);
    }
}