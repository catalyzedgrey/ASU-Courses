package com.asu.asucourses.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.asu.asucourses.R;

public class InstructorDetailsActivity extends AppCompatActivity {

    ImageView imgView;
    TextView instructorNameTV, instructorEmailTv, instructorBioTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_details);

        initViews();
        bindViews();
    }

    private void initViews(){
        imgView = findViewById(R.id.instructor_img_view);
        instructorNameTV = findViewById(R.id.instructor_tv);
        instructorEmailTv = findViewById(R.id.email_tv);
        instructorBioTV = findViewById(R.id.bio_tv);

    }

    private void bindViews(){
        //get extras and bind them with the UI.

    }
}
