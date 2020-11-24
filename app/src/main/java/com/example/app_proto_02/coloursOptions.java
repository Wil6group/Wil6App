package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class coloursOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours_options);
    }
    public void onColoursClick(View view)
    {
        startActivity(new Intent(coloursOptions.this, colours.class));
    }
    //public void onGameClick(View view)
    //{
    //startActivity(new Intent(coloursOptions.this, colourTest.class));
    //}
    public void onTestClick(View view)
    {
        startActivity(new Intent(coloursOptions.this, colourTest.class));
    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(coloursOptions.this, scroll_options.class));
    }
}