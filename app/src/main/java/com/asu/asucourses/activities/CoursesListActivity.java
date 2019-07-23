package com.asu.asucourses.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asu.asucourses.R;

public class CoursesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
    }

    private void getPrefData(){
        SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.SHARED_PREFS, MODE_PRIVATE);
        sharedPreferences.getString(LoginActivity.USER_ID, "");
        sharedPreferences.getFloat(LoginActivity.USER_GPA, 0f);
    }

}
