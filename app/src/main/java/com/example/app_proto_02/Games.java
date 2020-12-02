package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Games extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
    }

    public void onMatchingClick(View view)
    {
        startActivity(new Intent(Games.this, PicMatchingMenu.class));
    }
    public void onAnagramClick(View view)
    {
        startActivity(new Intent(Games.this, anagramMenu.class));
    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(Games.this, scroll_options.class));
    }
}