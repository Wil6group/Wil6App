package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class anagramMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anagram_menu);
    }

    public void onBackClick(View view) {
        startActivity(new Intent(anagramMenu.this, scroll_options.class));
    }

    public void onShapesClick(View view) {
        Intent intent = new Intent(getApplicationContext(), TestAnagram.class);
        intent.putExtra("ID", "Shapes");
        startActivity(intent);
    }

    public void onAnimalsClick(View view) {
        Intent intent = new Intent(getApplicationContext(), TestAnagram.class);
        intent.putExtra("ID", "Animals");
        startActivity(intent);
    }

    public void onNumbersClick(View view) {
        Intent intent = new Intent(getApplicationContext(), TestAnagram.class);
        intent.putExtra("ID", "Numbers");
        startActivity(intent);
    }

    public void onColoursClick(View view) {
        Intent intent = new Intent(getApplicationContext(), TestAnagram.class);
        intent.putExtra("ID", "Colours");
        startActivity(intent);
    }
}