package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bodyOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_options);
    }
    public void onBodyClick(View view)
    {
        startActivity(new Intent(bodyOptions.this, body.class));
    }
    //public void onGameClick(View view)
    //{
        //startActivity(new Intent(bodyOptions.this, bodyTest.class));
    //}
    public void onBackClick(View view)
    {
        startActivity(new Intent(bodyOptions.this, scroll_options.class));
    }
}