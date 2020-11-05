package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;

public class numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //ConstraintLayout NumView = findViewById(R.id.NumbersActivity);                                //Gradient background
        //AnimationDrawable animationDrawable = (AnimationDrawable) NumView.getBackground();            //Gradient background
        //animationDrawable.setEnterFadeDuration(2000);                                                 //Gradient background
        //animationDrawable.setExitFadeDuration(4000);                                                  //Gradient background
        //animationDrawable.start();                                                                    //Gradient background
    }


    public void onBackClick(View view)
    {
        startActivity(new Intent(numbers.this, scroll_options.class));
    }

    public void onAdditionClick(View v){

        Intent i = new Intent(this, MathGame.class);
        i.putExtra("extra", "Addition");
        startActivity(i);

    }

    public void onSubClick(View v){

        Intent i = new Intent(this, MathGame.class);
        i.putExtra("extra", "Subtraction");
        startActivity(i);

    }

    public void onDivClick(View v){

        Intent i = new Intent(this, MathGame.class);
        i.putExtra("extra", "Division");
        startActivity(i);

    }

    public void onMultiClick(View v){

        Intent i = new Intent(this, MathGame.class);
        i.putExtra("extra", "Multiplication");
        startActivity(i);

    }
}
