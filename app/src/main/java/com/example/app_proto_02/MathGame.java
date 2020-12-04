package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MathGame extends AppCompatActivity {
    //Score counter
    //Gamification

    public TextView operation;
    public TextView questNum;
    public TextView question;
    public ProgressBar progressBar;

    String mode;
    Button b1, b2, b3;
    List<Button> btnList = new ArrayList<Button>();
    List<String> answerList = new ArrayList<String>();

    int questionCounter, scoreCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);

        b1 = findViewById(R.id.btnMath1);
        b2 = findViewById(R.id.btnMath2);
        b3 = findViewById(R.id.btnMath3);

        btnList.add(b1);
        btnList.add(b2);
        btnList.add(b3);

        progressBar = findViewById(R.id.progressBar);
        questNum = findViewById(R.id.textView3);
        operation=(TextView)findViewById(R.id.OperationTxt);
        mode = getIntent().getStringExtra("extra");
        operation.setText(mode);

        questionCounter = 1;
        scoreCounter = 0;
        progressBar.setMax(10);
        CalculationOperation(mode);
    }

    public void EndGame(){
        Intent intent = new Intent(MathGame.this, ScoreManager.class);
        intent.putExtra("Section", "Maths");
        intent.putExtra("Game", mode);
        intent.putExtra("UserScore", scoreCounter);
        intent.putExtra("TotalScore", 10);
        startActivity(intent);
    }

    public void CalculationOperation(String operation){
        if (questionCounter < 11) {
            questNum.setText("Question " + questionCounter);
            progressBar.setProgress(questionCounter);
            answerList.clear();
            int ansInt;
            String ans;
            Random r = new Random();

            question = (TextView) findViewById(R.id.QuestionTxt);

            if(operation.equals("Addition")){
                int a = r.nextInt((30));
                int b = r.nextInt((30));
                String questio = a+" + "+b;
                question.setText(questio);

                ansInt = a+b;
                ans = Integer.toString(ansInt);
                for (int i = 0; i < 3; i++) {
                    while (answerList.contains(ans)){
                        ansInt = r.nextInt(a + b) + a;
                        ans = Integer.toString(ansInt);
                    }
                    answerList.add(ans);
                }
            }

            if(operation.equals("Subtraction")){
                int a = r.nextInt(50 - 25) + 25;
                int b = r.nextInt(25);
                String questio = a+" - "+b;
                question.setText(questio);

                ansInt = a-b;
                ans = Integer.toString(ansInt);
                for (int i = 0; i < 3; i++) {
                    while (answerList.contains(ans)){
                        ansInt = r.nextInt(a - b) + b;
                        ans = Integer.toString(ansInt);
                    }
                    answerList.add(ans);
                }

            }

            if(operation.equals("Division")){
                int a = r.nextInt((20)) + 1;
                int b = r.nextInt((10));
                int c = a*b;
                String questio = c+" / "+a;
                question.setText(questio);

                ansInt = c/a;
                ans = Integer.toString(ansInt);
                for (int i = 0; i < 3; i++) {
                    while (answerList.contains(ans)){
                        ansInt = r.nextInt(c + a);
                        ans = Integer.toString(ansInt);
                    }
                    answerList.add(ans);
                }
            }

            if(operation.equals("Multiplication")){
                int a = r.nextInt((12));
                int b = r.nextInt((12));
                String questio = a+" x "+b;
                question.setText(questio);

                ansInt = a*b;
                ans = Integer.toString(ansInt);
                for (int i = 0; i < 3; i++) {
                    while (answerList.contains(ans)){
                        ansInt = r.nextInt(ansInt + a + 1);
                        ans = Integer.toString(ansInt);
                    }
                    answerList.add(ans);
                }
            }

            for (int i = 0; i < 3; i++){
                btnList.get(i).setText(answerList.get(i));
            }
            // Collections.shuffle(btnList, new Random(1));

            int n = btnList.size();

            for (int k = n-1; k > 0; k--) {

                // Pick a random index from 0 to k
                int j = r.nextInt(k);

                // Swap arr[i] with the element at random index
                String value = btnList.get(k).getText().toString();
                btnList.get(k).setText(btnList.get(j).getText().toString());
                btnList.get(j).setText(value);
            }
        } else {
            EndGame();;
        }
    }

    public void onFirstClick(View view) {
        CheckAnswer(b1.getText().toString());
    }

    public void onSecondClick(View view) {
        CheckAnswer(b2.getText().toString());
    }

    public void onThirdClick(View view) {
        CheckAnswer(b3.getText().toString());
    }

    public void CheckAnswer(String ans){
        if (ans.equals(answerList.get(0))){
            scoreCounter++;
            Toast.makeText(this,"Well done, this is correct",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Wrong answer",Toast.LENGTH_SHORT).show();
        }
        questionCounter++;
        CalculationOperation(mode);
    }

    public void onBackClick(View view)
    {
        startActivity(new Intent(MathGame.this, numbersOptions.class));
    }

}