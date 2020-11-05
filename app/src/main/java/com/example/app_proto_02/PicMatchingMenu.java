package com.example.app_proto_02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PicMatchingMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_matching_menu);
    }

    public void onBackClick(View view) {
        startActivity(new Intent(PicMatchingMenu.this, scroll_options.class));
    }

    public void onShapesClick(View view) {
        Intent intent = new Intent(getApplicationContext(), PicMatching.class);
        intent.putExtra("ID", "Shapes");
        startActivity(intent);
    }

    public void onAnimalsClick(View view) {
        Intent intent = new Intent(getApplicationContext(), PicMatching.class);
        intent.putExtra("ID", "Animals");
        startActivity(intent);
    }
}