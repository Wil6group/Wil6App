package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;

public class body extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        //ConstraintLayout ColView = findViewById(R.id.ColoursActivity);                                //Gradient background
        //AnimationDrawable animationDrawable = (AnimationDrawable) ColView.getBackground();            //Gradient background
        //animationDrawable.setEnterFadeDuration(2000);                                                 //Gradient background
        //animationDrawable.setExitFadeDuration(4000);                                                  //Gradient background
        //animationDrawable.start();                                                                    //Gradient background
    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(body.this, scroll_options.class));
    }

    public void Part1(View view)
    {

    }
    public void Part2(View view)
    {

    }public void Part3(View view)
    {

    }public void Part4(View view)
    {

    }public void Part5(View view)
    {

    }public void Part6(View view)
    {

    }public void Part7(View view)
    {

    }public void Part8(View view)
    {

    }
    public void Part9(View view)
    {

    }
    public void Part10(View view)
    {

    }

}