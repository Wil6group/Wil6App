package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class colours extends AppCompatActivity {

    TextToSpeech t1;
    String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);

        //ConstraintLayout ColView = findViewById(R.id.ColoursActivity);                                //Gradient background
        //AnimationDrawable animationDrawable = (AnimationDrawable) ColView.getBackground();            //Gradient background
        //animationDrawable.setEnterFadeDuration(2000);                                                 //Gradient background
        //animationDrawable.setExitFadeDuration(4000);                                                  //Gradient background
        //animationDrawable.start();

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

    //---Colours button click
    public void Blue(View view)
    {
        word = "blue";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Red(View view)
    {
        word = "red";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Yellow(View view)
    {
        word = "yellow";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }public void Green(View view)
    {
        word = "green";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Pink(View view)
    {
        word = "pink";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Orange(View view)
    {
        word = "orange";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Brown(View view)
    {
        word = "brown";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Black(View view)
    {
        word = "black";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Purple(View view)
    {
        word = "purple";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Grey(View view)
    {
        word = "grey";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void LightBlue(View view)
    {
        word = "light blue";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void LightGreen(View view)
    {
        word = "light green";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(colours.this, coloursOptions.class));
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
