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

public class shapes extends AppCompatActivity {

    private SoundPool soundPool;
    private int circle, square, triangle, rectangel, oval, star, diamond, heart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);

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

        //circle = soundPool.load(this, R.raw.circle, 1);

    }

    //---Shapes button click
    public void Circle(View view)
    {
        //soundPool.play(circle, 1,1, 0, 0, 1);
    }
    public void Square(View view)
    {

    }
    public void Triangle(View view)
    {

    }public void Rectangle(View view)
    {

    }public void Oval(View view)
    {

    }public void Star(View view)
    {

    }
    public void Diamond(View view)
    {

    }
    public void Heart(View view)
    {

    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(shapes.this, scroll_options.class));
    }
    //---Shapes button end
}
