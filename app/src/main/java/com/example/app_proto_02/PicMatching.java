package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PicMatching extends AppCompatActivity { //Pic matching done by Shivaar. This Activity is in conjunction with ImageAdapter class.

    String choice = "";
    ImageView curView = null;
    private int countPair = 0;
    final int[] drawable = new int[8];
    private Chronometer chrom;
    private boolean running;

    TextView heading;

    int[] pos = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
    int currentPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_matching);

        heading = findViewById(R.id.titleH);

        Intent intent = getIntent();
        choice = intent.getStringExtra("ID");
         if ((choice.equals("Animals")) || (choice.equals("Animals1")))
         {
            setAniPics();
            heading.setText("Picture Matching Animals");
         }else if ((choice.equals("Shapes")) || (choice.equals("Shapes1")))
         {
             setShapePics();
             heading.setText("Picture Matching Shapes");
         }

        Random rand = new Random();
        for (int i = 0; i < pos.length; i++) {
            int randomIndexToSwap = rand.nextInt(pos.length);
            int temp = pos[randomIndexToSwap];
            pos[randomIndexToSwap] = pos[i];
            pos[i] = temp;
        }

        final GridView gridView = (GridView) findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);
        chrom = findViewById(R.id.simpleChronometer);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                startTimer(chrom);
                if (currentPos<0)
                {
                    currentPos = position;
                    curView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }else
                    {
                        if (currentPos == position)
                        {
                            ((ImageView)view).setImageResource(R.drawable.questionmark);
                        }else if(pos[currentPos] != pos[position])
                            {
                                ((ImageView)view).setImageResource(drawable[pos[position]]);

                                ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
                                ScheduledExecutorService s2 = scheduler;

                                scheduler.schedule(new Runnable() {
                                    @Override
                                    public void run() {
                                        ((ImageView) view).setImageResource(R.drawable.questionmark);

                                    }
                                }, 700, TimeUnit.MILLISECONDS);

                                s2.schedule(new Runnable() {
                                    @Override
                                    public void run() {
                                        curView.setImageResource(R.drawable.questionmark);
                                    }
                                }, 700, TimeUnit.MILLISECONDS);

                            } else
                                {
                                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                                    countPair++;

                                    if (countPair==8)
                                    {
                                        pauseTimer(chrom);
                                        int stoppedMilliseconds = TimerText();

                                        Toast.makeText(PicMatching.this, "You Win!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(PicMatching.this, ScoreManager.class);
                                        if (choice.lastIndexOf("1") != -1) {
                                            intent.putExtra("Section", choice.substring(0, choice.length()-1));
                                        }
                                        intent.putExtra("Game", "Picture Matching");
                                        intent.putExtra("UserScore", stoppedMilliseconds);
                                        intent.putExtra("TotalScore", 0);

                                        startActivity(intent);
                                    }
                                }
                        currentPos=-1;
                    }
            }
        });
    }

    public int TimerText(){
        int stoppedMilliseconds = 0;
        String chronoText = chrom.getText().toString();
        String array[] = chronoText.split(":");

        if (array.length == 2) {
            stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000
                    + Integer.parseInt(array[1]) * 1000;
        } else if (array.length == 3) {
            stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000
                    + Integer.parseInt(array[1]) * 60 * 1000
                    + Integer.parseInt(array[2]) * 1000;
        }
        return  stoppedMilliseconds;
    }

    public void onBackClick(View view)//In xml layout click on back button and set this method in the OnClick under attributes
    {
        if ((choice.equals("Animals")) || (choice.equals("Shapes")))
        {
            startActivity(new Intent(PicMatching.this, PicMatchingMenu.class));
        }
        else if (choice.equals("Animals1"))
        {
            startActivity(new Intent(PicMatching.this, animalsOptions.class));
        }
        else if (choice.equals("Shapes1"))
        {
            startActivity(new Intent(PicMatching.this, shapesOptions.class));
        }

    }

    public void setAniPics()
    {

        drawable[0] = R.drawable.chicken;
        drawable[1] = R.drawable.dog;
        drawable[2] = R.drawable.cat;
        drawable[3] = R.drawable.butterfly;
        drawable[4] = R.drawable.bee;
        drawable[5] = R.drawable.bird;
        drawable[6] = R.drawable.fish;
        drawable[7] = R.drawable.sheep;
    }

    public void setShapePics()
    {
        drawable[0] = R.drawable.matchcirc;
        drawable[1] = R.drawable.matchdiamond;
        drawable[2] = R.drawable.matchheart;
        drawable[3] = R.drawable.matchoval;
        drawable[4] = R.drawable.matchrect;
        drawable[5] = R.drawable.matchsquare;
        drawable[6] = R.drawable.matchstar;
        drawable[7] = R.drawable.matchtri;
    }

    public void startTimer(View view) {

        if(!running){
            chrom.start();
            running = true;
        }
    }

    public void pauseTimer(View view) {
        if(running){
            chrom.stop();
            running = false;
        }
    }
}

