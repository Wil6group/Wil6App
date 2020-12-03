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

    Button b_check;

    Random r;

    String currentWord,choice;
//Dictionary function used for the words, more can be added.
    String[] dictionary = {"", "", "", "", "", "", "", ""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_anagram);

        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_word = (TextView) findViewById(R.id.tv_word);

        et_guess = (EditText) findViewById(R.id.et_guess);

        b_check = (Button) findViewById(R.id.b_check);

        Intent intent = getIntent();
        choice = intent.getStringExtra("ID");
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



        r = new Random();

        newGame();

        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(et_guess.getText().toString().equalsIgnoreCase(currentWord)){
                    tv_info.setText("Awesome");
                    b_check.setEnabled(false);
                    newGame();
                } else{
                    tv_info.setText("Try again");
                    et_guess.setText("");
                }
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

        b_check.setEnabled(true);
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
        dictionary[0] = "one";
        dictionary[1] = "two";
        dictionary[2] = "three";
        dictionary[3] = "four";
        dictionary[4] = "five";
        dictionary[5] = "six";
        dictionary[6] = "seven";
        dictionary[7] = "eight";
    }
    public void setColourPics()
    {
        dictionary[0] = "blue";
        dictionary[1] = "red";
        dictionary[2] = "orange";
        dictionary[3] = "yellow";
        dictionary[4] = "green";
        dictionary[5] = "purple";
        dictionary[6] = "brown";
        dictionary[7] = "grey";
    }
    public void setShapePics()
    {
        dictionary[0] = "square";
        dictionary[1] = "circle";
        dictionary[2] = "triangle";
        dictionary[3] = "star";
        dictionary[4] = "rectangle";
        dictionary[5] = "diamond";
        dictionary[6] = "oval";
        dictionary[7] = "heart";
    }
    public void setAniPics()
    {
        dictionary[0] = "dog";
        dictionary[1] = "cat";
        dictionary[2] = "bee";
        dictionary[3] = "bird";
        dictionary[4] = "chicken";
        dictionary[5] = "fish";
        dictionary[6] = "sheep";
        dictionary[7] = "butterfly";
    }
    public void setBodyPics()
    {
        dictionary[0] = "arm";
        dictionary[1] = "handtest";
        dictionary[2] = "leg";
        dictionary[3] = "foot";
        dictionary[4] = "head";
        dictionary[5] = "chest";
        dictionary[6] = "stomach";
        dictionary[7] = "finger";
    }
}