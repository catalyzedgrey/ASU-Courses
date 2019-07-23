package com.asu.asucourses.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asu.asucourses.R;

public class SignUpActivity extends AppCompatActivity {
    EditText fullNameEditText,emailEditText,passwordEditText,confirmPasswordEditText,levelEditText,gpaEditText;
    Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void init(){
        fullNameEditText=findViewById(R.id.fullNameEditText);
        emailEditText=findViewById(R.id.emailEditText);
        passwordEditText=findViewById(R.id.passwordEditText);
        confirmPasswordEditText=findViewById(R.id.confirmPasswordEditText);
        levelEditText=findViewById(R.id.levelEditText);
        gpaEditText=findViewById(R.id.gpaEditText);
        registerBtn=findViewById(R.id.registerBtn);
    }
    private void validate(){
        // validate data
        //if valid n add student el mfrod f database
    }
}
