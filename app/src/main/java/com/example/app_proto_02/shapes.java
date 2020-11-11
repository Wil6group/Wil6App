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

public class shapes extends AppCompatActivity {

    TextToSpeech t1;
    String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);

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

    //---Shapes button click
    public void Circle(View view)
    {
        word = "circle";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Square(View view)
    {
        word = "square";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Triangle(View view)
    {
        word = "triangle";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }public void Rectangle(View view)
    {
        word = "rectangle";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }public void Oval(View view)
    {
        word = "oval";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }public void Star(View view)
    {
        word = "star";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Diamond(View view)
    {
        word = "diamond";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Heart(View view)
    {
        word = "heart";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(shapes.this, shapesOptions.class));
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
