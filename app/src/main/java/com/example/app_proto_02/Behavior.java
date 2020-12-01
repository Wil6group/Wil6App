package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class Behavior extends AppCompatActivity {

    TextToSpeech t1;
    String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);

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
        startActivity(new Intent(Behavior.this, scroll_options.class));
    }
    public void onMaskClick(View view)
    {
        word = "Wear your mask outside";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void onWashClick(View view)
    {
        word = "Keep your hands clean";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void onLineClick(View view)
    {
        word = "Wait your turn in line";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void onPlayClick(View view)
    {
        word = "Play nicely with others";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void onFriendsClick(View view)
    {
        word = "Have fun with your friends";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void onFamilyClick(View view)
    {
        word = "Love your family and pets";
        String toSpeak = word;
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
}