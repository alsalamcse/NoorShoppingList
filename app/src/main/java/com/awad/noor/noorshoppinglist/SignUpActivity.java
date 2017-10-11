package com.awad.noor.noorshoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity
{
    private EditText etName;
    private EditText etEmail;
    private EditText etpassword;
    private EditText etRePassword;
    private EditText etPhone;
    private Button btnSave;


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



    }
}
