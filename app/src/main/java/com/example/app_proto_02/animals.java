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
import android.view.View;

public class animals extends AppCompatActivity {

    private SoundPool soundPool;
    private int bird, bee, butterfly, cat, dog, chicken, sheep, fish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        //---Animal audio
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

        //bird = soundPool.load(this, R.raw.bird, 1);

    }

    //---Animals button click
    public void Bird(View view)
    {
        //soundPool.play(bird, 1,1, 0, 0, 1);
    }
    public void Bee(View view)
    {

    }
    public void Butterfly(View view)
    {

    }
    public void Cat(View view)
    {

    }
    public void Dog(View view)
    {

    }
    public void Chicken(View view)
    {

    }
    public void Sheep(View view)
    {

    }
    public void Fish(View view)
    {

    }
    public void onBackClick(View view) {
        startActivity(new Intent(animals.this, scroll_options.class));
    }
    //---Animals button click end
}
