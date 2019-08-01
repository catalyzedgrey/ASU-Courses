package com.asu.asucourses.activities;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


import com.asu.asucourses.R;
import com.asu.asucourses.adapters.CourseAdapter;
import com.asu.asucourses.interfaces.IService;
import com.asu.asucourses.models.Instructor;
import com.asu.asucourses.services.CoursesService;
import com.asu.asucourses.utils.Constants;
import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class InstructorDetailsActivity extends AppCompatActivity implements IService {

    ImageView imgView;
    TextView instructorNameTV, instructorEmailTv, instructorBioTV, smallNameTV;
    Instructor instructor;
    CircleImageView circleImageView, smallCircleImage;

    RecyclerView recView;
    CourseAdapter courseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_details);

        initViews();
        bindViews();
    }

    private void initViews() {

        //imgView = findViewById(R.id.instructor_img_view);
        instructorNameTV = findViewById(R.id.instructor_tv);
        instructorEmailTv = findViewById(R.id.email_tv);
        instructorBioTV = findViewById(R.id.bio_tv);
        circleImageView = findViewById(R.id.InstructorImage);
        smallCircleImage = findViewById(R.id.small_inst_img);
        smallNameTV = findViewById(R.id.small_inst_name);

        recView = findViewById(R.id.recycler_view);
        courseAdapter = new CourseAdapter();
        recView.setLayoutManager(new LinearLayoutManager(recView.getContext()));
        recView.setAdapter(courseAdapter);


        new CoursesService(this).execute(Constants.coursesUrl);


    }

    private Instructor getInstructorInfo() {
        return Constants.deserializeInstructorFromJson(getIntent().getStringExtra("instructorJson"));
    }

    private void bindViews() {
        instructor = getInstructorInfo();
        instructorNameTV.setText(instructor.getInstructorName());
        instructorEmailTv.setText(instructor.getEmail());
        //Glide.with(this).load(instructor.getInstructorImageUrl()).into(imgView);
        Glide.with(this).load(instructor.getInstructorImageUrl()).into(circleImageView);
        instructorBioTV.setText(instructor.getBio());

    }

    @Override
    public void onTaskCompleted(List objects) {
        courseAdapter.refreshCourseAdapter(objects);
    }
}
