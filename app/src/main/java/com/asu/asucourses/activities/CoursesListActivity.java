package com.asu.asucourses.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asu.asucourses.R;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.models.IService;
import com.asu.asucourses.services.CoursesService;
import com.asu.asucourses.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class CoursesListActivity extends AppCompatActivity implements IService {

    private List<Course> coursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);

        retrieveCourses();
    }

    private void retrieveCourses() {
        new CoursesService(this).execute(Constants.coursesUrl);
    }

    private void getPrefData(){
        SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.SHARED_PREFS, MODE_PRIVATE);
        sharedPreferences.getString(LoginActivity.USER_ID, "");
        sharedPreferences.getFloat(LoginActivity.USER_GPA, 0f);
    }


    @Override
    public void onTaskCompleted(List objects) {
        coursesList = (List<Course>) objects;
    }
}
