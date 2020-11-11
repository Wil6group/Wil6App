package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class animalsOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_options);
    }
    public void onAnimalsClick(View view)
    {
        startActivity(new Intent(animalsOptions.this, animals.class));
    }
    //public void onGameClick(View view)
    //{
        //startActivity(new Intent(animalsOptions.this, animalsGame.class));
    //}
    public void onBackClick(View view)
    {
        startActivity(new Intent(animalsOptions.this, scroll_options.class));
    }
}