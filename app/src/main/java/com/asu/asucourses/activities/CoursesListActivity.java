package com.asu.asucourses.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.asu.asucourses.R;
import com.asu.asucourses.adapters.CourseAdapter;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.models.IService;
import com.asu.asucourses.services.CoursesService;
import com.asu.asucourses.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class CoursesListActivity extends AppCompatActivity implements IService {

    CourseAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);

        initViews();
        retrieveCourses();
    }

    private void initViews(){
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new CourseAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
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
        adapter.refreshCourseAdapter(objects);
    }
}
