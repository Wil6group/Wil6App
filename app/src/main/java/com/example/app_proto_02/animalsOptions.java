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
    public void onAnimalGameClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), PicMatching.class);
        intent.putExtra("ID", "Animals");
        startActivity(intent);
    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(animalsOptions.this, scroll_options.class));
    }

    public void onTestClick(View view)
    {
        startActivity(new Intent(animalsOptions.this, animalTest.class));
    }
}