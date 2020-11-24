package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class shapesOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes_options);
    }
    public void onShapesClick(View view)
    {
        startActivity(new Intent(shapesOptions.this, shapes.class));
    }
    public void onShapeGameClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), PicMatching.class);
        intent.putExtra("ID", "Shapes");
        startActivity(intent);
    }
    public void onShapesTestClick(View view)
    {
        startActivity(new Intent(shapesOptions.this, shapesTest.class));
    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(shapesOptions.this, scroll_options.class));
    }
}