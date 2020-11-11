package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class body extends AppCompatActivity {

    TextToSpeech t1;
    String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        //ConstraintLayout ColView = findViewById(R.id.ColoursActivity);                                //Gradient background
        //AnimationDrawable animationDrawable = (AnimationDrawable) ColView.getBackground();            //Gradient background
        //animationDrawable.setEnterFadeDuration(2000);                                                 //Gradient background
        //animationDrawable.setExitFadeDuration(4000);                                                  //Gradient background
        //animationDrawable.start();                                                                    //Gradient background

        //Speech
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR)
                {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(body.this, bodyOptions.class));
    }

    public void Head(View view)
    {
        word = "head";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Neck(View view)
    {
        word = "neck";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }public void Arm(View view)
    {
        word = "arm";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }public void Hand(View view)
    {
        word = "hand";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }public void Chest(View view)
    {
        word = "chest";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }public void Stomach(View view)
    {
        word = "stomach";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }public void Leg(View view)
    {
        word = "leg";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }public void Knee(View view)
    {
        word = "knee";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Foot(View view)
    {
        word = "foot";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Toes(View view)
    {
        word = "toes";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void onPause()
    {
        if(t1!=null)
        {
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}