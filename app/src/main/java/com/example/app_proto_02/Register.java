package com.example.app_proto_02;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText user,pass,email;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        InitializeFields();
        progressBar.setVisibility(View.GONE);

        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            //startActivity(new Intent(Register.this, MainActivity.class));
        }
    }

    public void onBackClick(View view)
    {
        startActivity(new Intent(Register.this, Login.class));
    }

    public void OnRegisterClick(View view)
    {
        if ((user.getText().equals(null)) || (pass.getText().equals(null)) || (email.getText().equals(null)))
        {
            Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
        }else
        {
            createAccount();
        }
    }

    private void createAccount()
    {
        String userEmail = email.getText().toString();
        String password = pass.getText().toString();

        if (TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(password) || TextUtils.isEmpty(pass.getText().toString()))
        {
            Toast.makeText(this, "Please enter all fields...", Toast.LENGTH_SHORT).show();
        }else{

            progressBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(userEmail,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                User fbUser = new User(user.getText().toString(), email.getText().toString()); //Adds new user to database
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                myRef.child("Scores").setValue(new Score("Control", "Control", 0, 0));
                                myRef.child("User").setValue(fbUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful())
                                        {
                                            Toast.makeText(Register.this, "User created successfully...", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(Register.this, Login.class));
                                        }else{
                                            String message = task.getException().toString();
                                            Toast.makeText(Register.this, "Error: Process could not be completed.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                            }else
                            {
                                String message = task.getException().toString();
                                Toast.makeText(Register.this, "Error: Process could not be completed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void InitializeFields()
    {
        user = findViewById(R.id.etUsername);
        pass = findViewById(R.id.etPass);
        email = findViewById(R.id.etEmail2);

        progressBar = findViewById(R.id.progressbar2);
    }
}