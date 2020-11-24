package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class PicMatching extends AppCompatActivity { //Pic matching done by Shivaar. This Activity is in conjunction with ImageAdapter class.

    String choice = "";
    ImageView curView = null;
    private int countPair = 0;
    final int[] drawable = new int[8];

    int[] pos = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
    int currentPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_matching);

        Intent intent = getIntent();
        choice = intent.getStringExtra("ID");
         if (choice.equals("Animals"))
         {
            setAniPics();
         }else if (choice.equals("Shapes"))
         {
             setShapePics();
         }

        GridView gridView = (GridView) findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentPos<0)
                {
                    currentPos = position;
                    curView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }else
                    {
                        if (currentPos == position)
                        {
                            ((ImageView)view).setImageResource(R.drawable.questionmark);
                        }else if(pos[currentPos] != pos[position])
                            {
                                curView.setImageResource(R.drawable.questionmark);
                                Toast.makeText(PicMatching.this, "No Match", Toast.LENGTH_SHORT).show();
                            }else
                                {
                                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                                    countPair++;

                                    if (countPair==0)
                                    {
                                        Toast.makeText(PicMatching.this, "You Win!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        currentPos=-1;
                    }
            }
        });
    }

    public void onBackClick(View view)//In xml layout click on back button and set this method in the OnClick under attributes
    {
        startActivity(new Intent(PicMatching.this, scroll_options.class));
    }

    public void setAniPics()
    {

        drawable[0] = R.drawable.chicken;
        drawable[1] = R.drawable.dog;
        drawable[2] = R.drawable.cat;
        drawable[3] = R.drawable.butterfly;
        drawable[4] = R.drawable.bee;
        drawable[5] = R.drawable.bird;
        drawable[6] = R.drawable.fish;
        drawable[7] = R.drawable.sheep;
    }

    public void setShapePics()
    {
        drawable[0] = R.drawable.matchcirc;
        drawable[1] = R.drawable.matchdiamond;
        drawable[2] = R.drawable.matchheart;
        drawable[3] = R.drawable.matchoval;
        drawable[4] = R.drawable.matchrect;
        drawable[5] = R.drawable.matchsquare;
        drawable[6] = R.drawable.matchstar;
        drawable[7] = R.drawable.matchtri;
    }
}