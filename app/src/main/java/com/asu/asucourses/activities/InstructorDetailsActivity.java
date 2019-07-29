package com.asu.asucourses.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.models.Instructor;
import com.asu.asucourses.utils.Constants;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class InstructorDetailsActivity extends AppCompatActivity {

    ImageView imgView;
    TextView instructorNameTV, instructorEmailTv, instructorBioTV;
    Instructor instructor;
    CircleImageView circleImageView;

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
}
