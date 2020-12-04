package com.example.app_proto_02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ScoreManager extends AppCompatActivity {

    Score scoreObj;

    ImageView stars;
    TextView textSection, textGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_manager);

        Intent intent = getIntent();
        String section = intent.getStringExtra("Section");
        String game = intent.getStringExtra("Game");
        int userScore = intent.getIntExtra("UserScore", 0);
        int totalScore = intent.getIntExtra("TotalScore", 0);
      /*  section = "Numbers";
        game = "Addition";
        userScore = 7;
        totalScore = 10;*/

        scoreObj = new Score(section, game, userScore, totalScore);

        textSection = findViewById(R.id.txtSection);
        textGame = findViewById(R.id.txtGame);

        textSection.setText(section);
        textGame.setText(game);

        DisplayStars(userScore, totalScore);
        AddToFirebase();
    }

    public void onHomeClick(View view) {
        startActivity(new Intent(ScoreManager.this, scroll_options.class));
    }

    public void DisplayStars(int uS, int tS){
        stars = findViewById(R.id.imgStar);

        if (tS != 0) {
            if (uS == tS) {
                stars.setImageResource(R.drawable.star3);
            } else if (uS >= (tS / 2)) {
                stars.setImageResource(R.drawable.star2);
            } else {
                stars.setImageResource(R.drawable.star1);
            }
        } else {
            if (uS < 60 * 1000) {
                stars.setImageResource(R.drawable.star3);
            } else if (uS < 180 * 1000) {
                stars.setImageResource(R.drawable.star2);
            } else {
                stars.setImageResource(R.drawable.star1);
            }
        }
    }
    public void AddToFirebase(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String uid = mAuth.getCurrentUser().getUid();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(uid).child("Scores").child(FirebaseHelper(scoreObj.getSection(), scoreObj.getGame()));

        myRef.setValue(scoreObj).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(ScoreManager.this, "Score saved successfully...", Toast.LENGTH_SHORT).show();
                }else{
                    String message = task.getException().toString();
                    Toast.makeText(ScoreManager.this, "Error: Process could not be completed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String FirebaseHelper(String section, String game){
        if (section.equals("Animals") && game.equals("Quiz")) { return "Game1"; }
        if (section.equals("Animals") && game.equals("Picture Matching")) { return "Game2"; }
        if (section.equals("Shapes") && game.equals("Quiz")) { return "Game3"; }
        if (section.equals("Shapes") && game.equals("Picture Matching")) { return "Game4"; }
        if (section.equals("Body") && game.equals("Quiz")) { return "Game5"; }
        if (section.equals("Body") && game.equals("Anagram")) { return "Game6"; }
        if (section.equals("Colours") && game.equals("Quiz")) { return "Game7"; }
        if (section.equals("Colours") && game.equals("Anagram")) { return "Game8"; }
        if (section.equals("Maths") && game.equals("Addition")) { return "Game9"; }
        if (section.equals("Maths") && game.equals("Subtraction")) { return "Game10"; }
        if (section.equals("Maths") && game.equals("Multiplication")) { return "Game11"; }
        if (section.equals("Maths") && game.equals("Division")) { return "Game12"; }
        if (section.equals("Maths") && game.equals("Anagram")) { return "Game13"; }
        if (section.equals("Animals") && game.equals("Anagram")) { return "Game14"; }
        if (section.equals("Shapes") && game.equals("Anagram")) { return "Game15"; }


        return null;
    }
}