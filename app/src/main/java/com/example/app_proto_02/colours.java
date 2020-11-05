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
import android.view.View;

public class colours extends AppCompatActivity {

    //Colour audio
    private SoundPool soundPool;
    private int blue, red, yellow, green, purple, pink, orange, brown, black, grey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);

        //ConstraintLayout ColView = findViewById(R.id.ColoursActivity);                                //Gradient background
        //AnimationDrawable animationDrawable = (AnimationDrawable) ColView.getBackground();            //Gradient background
        //animationDrawable.setEnterFadeDuration(2000);                                                 //Gradient background
        //animationDrawable.setExitFadeDuration(4000);                                                  //Gradient background
        //animationDrawable.start();

        //---Colour audio
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        }

        blue = soundPool.load(this, R.raw.blue, 1);
    }

    //---Colours button click
    public void Blue(View view)
    {
        soundPool.play(blue, 1,1, 0, 0, 1);
    }
    public void Red(View view)
    {

    }
    public void Yellow(View view)
    {

    }public void Green(View view)
    {

    }public void Purple(View view)
    {

    }
    public void Pink(View view)
    {

    }
    public void Orange(View view)
    {

    }
    public void Brown(View view)
    {

    }
    public void Black(View view)
    {

    }
    public void Grey(View view)
    {

    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(colours.this, scroll_options.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
