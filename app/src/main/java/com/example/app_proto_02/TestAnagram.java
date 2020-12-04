package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
//Done by Sagel.
public class TestAnagram extends AppCompatActivity {

    TextView tv_info, tv_word, tv_num;

    EditText et_guess;

    Button b_check;

    Random r;

    String currentWord,choice;
    int score, totalQuestions, currentQuestion;

//Dictionary function used for the words, more can be added.
    List<String> dictionary = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_anagram);

        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_word = (TextView) findViewById(R.id.textView3);
        tv_num = (TextView) findViewById(R.id.questionNum);

        et_guess = (EditText) findViewById(R.id.et_guess);

        b_check = (Button) findViewById(R.id.b_check);

        Intent intent = getIntent();
        choice = intent.getStringExtra("ID");
        dictionary.clear();;
        if (choice.equals("Animals"))
        {
            setAniPics();
        }else if (choice.equals("Shapes"))
        {
            setShapePics();
        }else if ((choice.equals("Colours")) || (choice.equals("Colours1")))
        {
            setColourPics();
        }else if ((choice.equals("Numbers")) || (choice.equals("Numbers1")))
        {
            setNumberPics();
        }else if ((choice.equals("Body")) || (choice.equals("Body1")))
        {
            setBodyPics();
        }

        Collections.shuffle(dictionary);

        r = new Random();

        score = 0;
        currentQuestion = 1;
        totalQuestions = dictionary.size();

        newGame();

        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String guess = et_guess.getText().toString();
                if (guess.isEmpty()){
                    Toast.makeText(TestAnagram.this, "Please enter an answer", Toast.LENGTH_SHORT).show();
                    et_guess.requestFocus();
                    return;
                }

                if(guess.equalsIgnoreCase(currentWord)){
                    Toast.makeText(TestAnagram.this, "Awesome", Toast.LENGTH_SHORT).show();
                    b_check.setEnabled(false);
                    score++;
                } else {
                    Toast.makeText(TestAnagram.this, "Unlucky", Toast.LENGTH_SHORT).show();
                }

                et_guess.setText("");
                currentQuestion++;
                newGame();
            }
        });

    }

    private String shuffleWord(String word){
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for(String letter: letters){
            shuffled += letter;
        }
        return shuffled;
    }

    private void newGame(){
        if (currentQuestion < totalQuestions + 1) {
            tv_num.setText("Question " + currentQuestion);
            currentWord = dictionary.get(currentQuestion-1);
            tv_word.setText(shuffleWord(currentWord));
            et_guess.setText("");
            b_check.setEnabled(true);
        } else {
            EndGame();
        }
    }

    public void EndGame(){
        Intent intent = new Intent(TestAnagram.this, ScoreManager.class);
        if (choice.lastIndexOf("1") != -1) {
            intent.putExtra("Section", choice.substring(0, choice.length()-1));
        }
        intent.putExtra("Game", "Anagram");
        intent.putExtra("UserScore", score);
        intent.putExtra("TotalScore", totalQuestions);
        startActivity(intent);
    }

    public void onBackClick(View view)
    {
        if ((choice.equals("Animals")) || (choice.equals("Shapes")) || (choice.equals("Colours")) || (choice.equals("Numbers")) || (choice.equals("Body")))
        {
            startActivity(new Intent(TestAnagram.this, anagramMenu.class));
        }
        else if (choice.equals("Colours1"))
        {
            startActivity(new Intent(TestAnagram.this, coloursOptions.class));
        }
        else if (choice.equals("Numbers1"))
        {
            startActivity(new Intent(TestAnagram.this, numbersOptions.class));
        }
        else if (choice.equals("Body1"))
        {
            startActivity(new Intent(TestAnagram.this, bodyOptions.class));
        }
    }

    public void setNumberPics()
    {
        dictionary.add("one");
        dictionary.add("two");
        dictionary.add("three");
        dictionary.add("four");
        dictionary.add("five");
        dictionary.add("six");
        dictionary.add("seven");
        dictionary.add("eight");
        dictionary.add("nine");
        dictionary.add("ten");
    }
    public void setColourPics()
    {
        dictionary.add("blue");
        dictionary.add("red");
        dictionary.add("green");
        dictionary.add("yellow");
        dictionary.add("orange");
        dictionary.add("pink");
        dictionary.add("purple");
        dictionary.add("black");
        dictionary.add("grey");
        dictionary.add("brown");
    }
    public void setShapePics()
    {
        dictionary.add("circle");
        dictionary.add("diamond");
        dictionary.add("heart");
        dictionary.add("oval");
        dictionary.add("rectangle");
        dictionary.add("square");
        dictionary.add("star");
        dictionary.add("triangle");
    }
    public void setAniPics()
    {
        dictionary.add("bee");
        dictionary.add("bird");
        dictionary.add("cat");
        dictionary.add("dog");
        dictionary.add("chicken");
        dictionary.add("fish");
        dictionary.add("sheep");
        dictionary.add("butterfly");
    }
    public void setBodyPics()
    {
        dictionary.add("head");
        dictionary.add("neck");
        dictionary.add("arm");
        dictionary.add("hand");
        dictionary.add("chest");
        dictionary.add("stomach");
        dictionary.add("leg");
        dictionary.add("knee");
        dictionary.add("foot");
    }
}