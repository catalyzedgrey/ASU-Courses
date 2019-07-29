package com.asu.asucourses.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.application.User;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.models.Instructor;
import com.asu.asucourses.utils.Constants;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;


public class CoursesDetailsActivity extends AppCompatActivity {

    ImageView courseImage;
    CircleImageView instructorImage;
    TextView courseTitle;
    TextView instructorName;
    TextView courseDetails;
    TextView minGPA;
    Button enroll;
    View instructorView;
    Course course;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String USER_ID = "userId";
    public static final String USER_GPA = "gpa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_details);
        this.course = getCourseDetails();
        initViews();
        bindViews();
    }

    private void initViews() {
        courseImage = findViewById(R.id.CourseImage);
        instructorImage = findViewById(R.id.InstructorImage);
        courseTitle = findViewById(R.id.CourseTitletextView);
        instructorName = findViewById(R.id.InstructorNameTextView);
        courseDetails = findViewById(R.id.CourseDetailsTextView);
        minGPA = findViewById(R.id.minGPA);
        enroll = findViewById(R.id.enrollBtn);
        instructorView = findViewById(R.id.InstructorView);
        instructorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CoursesDetailsActivity.this, InstructorDetailsActivity.class);
                String instructorJson = Constants.serializeInstructorToJson(course.getInstructor());
                //  Instructor instructor = new Instructor("1", "Jane Smith", "https://www.virversity.com/images/dowell/courses/createacourse/oc/courseintroimage.jpg",
                //          "test@test.com", "Professor");
                // String instructorJson = Constants.serializeInstructorToJson(instructor);
                i.putExtra("instructorJson", instructorJson);
                startActivity(i);
            }
        });
        //check if user is logged in to enable and disable enroll button
        if (!loggedIn()) {
            enroll.setEnabled(false);
        }
        //check user gpa to enable and disable enroll button accordingly
        if (!CheckGPA(course)) {
            minGPA.setText("Minimum GPA is" + course.getMinGPA());
            minGPA.setVisibility(View.VISIBLE);
            enroll.setEnabled(false);
        }
        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //added to "My Courses"
            }
        });


    }

    //Returns a course object from json string
    private Course getCourseDetails() {
        return Constants.deserializeCourseFromJson(getIntent().getStringExtra("courseJson"));
    }


    public void bindViews() {
        Glide.with(this).load(course.getCourseImageUrl()).into(courseImage);
        Glide.with(this).load(course.getInstructor().getInstructorImageUrl()).into(instructorImage);
        courseTitle.setText(course.getCourseName());
        instructorName.setText(course.getInstructor().getInstructorName());
        courseDetails.setText(course.getCourseDescription());
    }

    public boolean loggedIn() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final String restoredText = prefs.getString(USER_ID, null);
        if (restoredText != null) {
            return true;
        }
        return false;

    }

    public boolean CheckGPA(Course course) {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final String restoredText = prefs.getString(USER_GPA, "0");
        if (Float.parseFloat(restoredText) < course.getMinGPA()) {
            return true;
        }
        return false;
    }
}
