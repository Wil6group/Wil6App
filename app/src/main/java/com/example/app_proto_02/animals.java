package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class animals extends AppCompatActivity {

    TextToSpeech t1;
    String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

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

    //---Animals button click
    public void Bird(View view)
    {
        word = "bird";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Bee(View view)
    {
        word = "bee";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Butterfly(View view)
    {
        word = "butterfly";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Cat(View view)
    {
        word = "cat";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Dog(View view)
    {
        word = "dog";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Chicken(View view)
    {
        word = "chicken";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Sheep(View view)
    {
        word = "sheep";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void Fish(View view)
    {
        word = "fish";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void onBackClick(View view) {
        startActivity(new Intent(animals.this, animalsOptions.class));
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
