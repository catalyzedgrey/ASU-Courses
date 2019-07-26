package com.asu.asucourses.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.application.User;
import com.asu.asucourses.models.Course;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_details);
        courseImage = findViewById(R.id.CourseImage);
        instructorImage = findViewById(R.id.InstructorImage);
        courseTitle = findViewById(R.id.CourseTitletextView);
        instructorName = findViewById(R.id.InstructorNameTextView);
        courseDetails = findViewById(R.id.CourseDetailsTextView);
        minGPA = findViewById(R.id.minGPA);
        enroll = findViewById(R.id.enrollBtn);
        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //added to "My Courses"
            }
        });
        //test
        setParameters(courseImage,instructorImage,courseTitle,instructorName,courseDetails);
    }

    //Check users eligibility to enroll to course
    public void CheckGPA(User user, Course course) {
        if (Float.parseFloat(user.getGpa()) < course.getMinGPA()) {
            minGPA.setText("Minimum GPA is" + course.getMinGPA());
            minGPA.setVisibility(View.VISIBLE);
            enroll.setEnabled(false);

        }
    }

    //Set Course Parameters with data sent from service
    public void setParameters(ImageView courseImage, CircleImageView instructorImage, TextView courseTitle, TextView instructorName, TextView courseDetails) {
        //Todo: To be replaced with service
        //Dummy inputs
        String[] URLS = {"https://www.virversity.com/images/dowell/courses/createacourse/oc/courseintroimage.jpg"};
        Glide.with(this).load(URLS[0]).into(this.courseImage);
        Glide.with(this).load(URLS[0]).into(this.instructorImage);
        this.courseTitle.setText("Physics");
        this.instructorName.setText("John");
        this.courseDetails.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dapibus quis leo nec luctus. Nam sit amet est orci. Vestibulum fermentum eros magna, hendrerit rhoncus enim lacinia eu.");
    }
}
