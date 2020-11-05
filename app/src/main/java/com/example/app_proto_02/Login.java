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
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText email,pass;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitializeFields();
        progressBar.setVisibility(View.GONE);
        mAuth = FirebaseAuth.getInstance();
    }

    public void onLoginClick(View view)
    {
        userLogin();
    }

    public void onRegisterClick(View view)
    {
        startActivity(new Intent(Login.this, Register.class));
    }

    private void userLogin()  //Checks if user exists in my Firebase Database
    {
        String userEmail = email.getText().toString();
        String password = pass.getText().toString();

        if (TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please enter all fields...", Toast.LENGTH_SHORT).show();
        }else
        {
            progressBar.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(userEmail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.setVisibility(View.GONE);
                    if (task.isSuccessful())
                    {
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        Intent temp = new Intent(Login.this, scroll_options.class);
                        startActivity(temp);
                        Toast.makeText(Login.this, "Signed in successfully", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        String message = task.getException().toString();
                        Toast.makeText(Login.this, "Error: Incorrect details or user does not exist!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void InitializeFields()
    {
        email = findViewById(R.id.etEmail);
        pass = findViewById(R.id.etPassword);
        progressBar = findViewById(R.id.progressbarmain);
    }
}