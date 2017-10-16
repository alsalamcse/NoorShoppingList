package com.awad.noor.noorshoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity
{
    private EditText etName;
    private EditText etEmail;
    private EditText etpassword;
    private EditText etRePassword;
    private EditText etPhone;
    private Button btnSave;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etName= (EditText)findViewById(R.id.etName);
        etEmail= (EditText)findViewById(R.id.etEmail);
        etpassword= (EditText)findViewById(R.id.etPassword);
        etRePassword= (EditText)findViewById(R.id.etRePassword);
        etPhone= (EditText)findViewById(R.id.etPhone);
        btnSave= (Button)findViewById(R.id.btnSave);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();


        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        if (firebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        } else {
            String userName = firebaseUser.getDisplayName();
            if (firebaseUser.getPhotoUrl() != null) {
                String   photoUrl = firebaseUser.getPhotoUrl().toString();
            }
        }

    }
        }


    }

}
