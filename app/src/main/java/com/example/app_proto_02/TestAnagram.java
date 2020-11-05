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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
//Done by Sagel.
public class TestAnagram extends AppCompatActivity {

    TextView tv_info, tv_word;

    EditText et_guess;

    Button b_check, b_new;

    Random r;

    String currentWord;
//Dictionary function used for the words, more can be added.
    String[] dictionary = {
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_anagram);

        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_word = (TextView) findViewById(R.id.tv_word);

        et_guess = (EditText) findViewById(R.id.et_guess);

        b_check = (Button) findViewById(R.id.b_check);
        b_new = (Button) findViewById(R.id.b_new);

        r = new Random();

        newGame();

        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(et_guess.getText().toString().equalsIgnoreCase(currentWord)){
                    tv_info.setText("Awesome");
                    b_check.setEnabled(false);
                    b_new.setEnabled(true);
                    newGame();
                } else{
                    tv_info.setText("Try again");
                }
            }
        });


        b_new.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
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
        currentWord = dictionary[r.nextInt(dictionary.length)];

        tv_word.setText(shuffleWord(currentWord));

        et_guess.setText("");

        b_new.setEnabled(false);
        b_check.setEnabled(true);
    }

    public void onBackClick(View view)
    {
        startActivity(new Intent(TestAnagram.this, scroll_options.class));
    }
}