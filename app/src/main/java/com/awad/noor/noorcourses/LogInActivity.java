package com.awad.noor.noorcourses;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String PREF_FILE_NAME= "NoorPref";
    private EditText etEmail;
    private EditText etPassword;
    private Button btnIn;
    private Button btnUp;
    private Button btnsearch;

    private FirebaseUser firebaseUser;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnUp = (Button) findViewById(R.id.btnUp);
        btnUp.setOnClickListener(this);
        btnIn = (Button) findViewById(R.id.btnIn);
        btnIn.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        btnsearch=(Button) findViewById(R.id.btnsearch);


    }


    private void dataHandler() {
        String email = etEmail.getText().toString();
        String passw = etPassword.getText().toString();
        boolean isOk = true;//to check if all feilds are filled correctly

        signIn(email, passw);
    }


    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LogInActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LogInActivity.this,Listofcourses.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LogInActivity.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view==btnUp){
            Intent i = new Intent(this,SignUpActivity.class);
            startActivity(i);
        }

        if (view==btnIn){
            dataHandler();
        }
    }
}

