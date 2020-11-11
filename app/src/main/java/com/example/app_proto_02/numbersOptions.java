package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class numbersOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_options);
    }
    public void onNumbersClick(View view)
    {
        startActivity(new Intent(numbersOptions.this, numbers.class));
    }
    //public void onGameClick(View view)
    //{
    //startActivity(new Intent(numbersOptions.this, numbersTest.class));
    //}
    public void onBackClick(View view)
    {
        startActivity(new Intent(numbersOptions.this, scroll_options.class));
    }
}