package com.asu.asucourses.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asu.asucourses.R;

public class LoginActivity extends AppCompatActivity {
    EditText EmailEditText,PasswordEditText;
    Button SignInBtn,SignUpBtn;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String USER_ID = "userId";
    public static final String USER_GPA = "gpa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        init();


        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });


        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateANDverify();
            }
        });

    }

    private void init(){
        EmailEditText=findViewById(R.id.EmailEditText);
        PasswordEditText=findViewById(R.id.PasswordEditText);
        SignInBtn=findViewById(R.id.SignInBtn);
        SignUpBtn=findViewById(R.id.SignUpBtn);
    }

    private void savePrefData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Todo: To be implemented
//        editor.putString(USER_ID, );
//        editor.putFloat(USER_GPA, );

        editor.apply();
    }

    private void validateANDverify(){
        // Todo: To be implemented
        //validate inputs
        //if valid , hn3ml request n verify el account
        //verify student dh mowgod f database wla la
        //low ah hn-redirect student 3la MainActivity
        //low la loginActivity w n2olo ank msh student m3ana
        // savePrefData()
    }
}
