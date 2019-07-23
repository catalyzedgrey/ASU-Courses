package com.asu.asucourses.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asu.asucourses.R;

public class LoginActivity extends AppCompatActivity {
    EditText EmailEditText,PasswordEditText;
    Button SignInBtn,SignUpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        init();


        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(LoginActivity.this,RegisterActivity.class);
            }
        });


        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate inputs
                //if valid , hn3ml request n verify el account
            }
        });

    }

    private void init(){
        EmailEditText=findViewById(R.id.EmailEditText);
        PasswordEditText=findViewById(R.id.PasswordEditText);
        SignInBtn=findViewById(R.id.SignInBtn);
        SignUpBtn=findViewById(R.id.SignUpBtn);
    }
}
