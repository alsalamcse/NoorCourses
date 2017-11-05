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

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String PREF_FILE_NAME= "NoorPref";
    private Button btnSave;
    private Button btndelete;
    private EditText eTusername;
    private EditText eTemail;
    private EditText eTPassword;
    private FirebaseUser firebaseUser;
    private FirebaseAuth auth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSave=(Button) findViewById(R.id.btnSave);
        btndelete=(Button) findViewById(R.id.btndelete);
        eTusername=(EditText) findViewById(R.id.eTusername);
        eTemail=(EditText) findViewById(R.id.eTemail);
        eTPassword=(EditText) findViewById(R.id.etPassword);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        btnSave.setOnClickListener(this);
        btndelete.setOnClickListener(this);
    }


    private void dataHandler(){
        String email=eTemail.getText().toString();
        String passw=eTPassword.getText().toString();
        String user=eTusername.getText().toString();
        boolean isOk=true;//to check if all feilds are filled correctly

        createAccount(email,passw);
    }

        private void createAccount(String email, String passw) {
            auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SignUpActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                        //updateUserProfile(task.getResult().getUser());
                        finish();
                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this, "Authentication failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        task.getException().printStackTrace();
                    }
                }
            });
        }


    @Override
    public void onClick(View view) {
        dataHandler();
    }
}