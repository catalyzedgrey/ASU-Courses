package com.asu.asucourses.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.asu.asucourses.R;
import com.asu.asucourses.application.User;
import com.asu.asucourses.interfaces.IService;
import com.asu.asucourses.services.RegisterService;
import com.asu.asucourses.utils.Constants;

import java.util.List;

public class SignUpActivity extends AppCompatActivity implements IService {
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

        String fullName=fullNameEditText.getText().toString();
        String email=emailEditText.getText().toString();
        String password=passwordEditText.getText().toString();
        String confirmPassword=confirmPasswordEditText.getText().toString();
        String level=levelEditText.getText().toString();
        String gpa=gpaEditText.getText().toString();

        if(!checkEmpty(fullName,email,password,confirmPassword,level,gpa)){
            if(validateANDverify(password,confirmPassword,level,gpa)){
                //Todo: nshof email dh mwgod f database wla la
                User user = new User(fullName, email, password, gpa, level);
                String userMessage = Constants.serializeUserToJson(user);
                new RegisterService(this).execute(Constants.registerUrl, userMessage);
            }
        }

    }


    private boolean checkEmpty(String fullName,String email,String password,String confirmPassword,String level,String gpa){
        if(fullName.isEmpty()){
            Toast.makeText(SignUpActivity.this,"u must enter ur full name !",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(email.isEmpty()){
            Toast.makeText(SignUpActivity.this,"u must enter ur email !",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(password.isEmpty()){
            Toast.makeText(SignUpActivity.this,"u must enter ur password !",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(confirmPassword.isEmpty()){
            Toast.makeText(SignUpActivity.this,"u must confirm ur password !",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(level.isEmpty()){
            Toast.makeText(SignUpActivity.this,"u must enter ur level !",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(gpa.isEmpty()){
            Toast.makeText(SignUpActivity.this,"u must enter ur gpa !",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }




    private boolean validateANDverify(String password,String confirmPassword,String level,String gpa){
        int LEVEL=Integer.valueOf(level);
        float GPA=Float.valueOf(gpa);
        if(LEVEL>=0&&LEVEL<=4){
            if(GPA>=0&&GPA<=4){
                if(password.matches("[a-zA-Z.\\-_*&^%$@]*[0-9.\\-_*&^%$@]+[a-zA-Z.\\-_*&^%$@]*[0-9.\\-_*&^%$@]+[a-zA-Z.\\-_*&^%$@]*")&&password.length()>6){
                    if(password.equals(confirmPassword)){
                        return true;
                    }else {
                        Toast.makeText(SignUpActivity.this,"ur password must match ur confirm password",Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }else {
                    Toast.makeText(SignUpActivity.this,"ur password must have at least on special character & number & have size of 6 characters",Toast.LENGTH_SHORT).show();
                    return false;
                }
            }else{
                Toast.makeText(SignUpActivity.this,"ur gpa must be in range 0 to 4",Toast.LENGTH_SHORT).show();
                return false;
            }
        }else{
            Toast.makeText(SignUpActivity.this,"ur level must be in range 0 to 4",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onTaskCompleted(List objects) {

    }
}
