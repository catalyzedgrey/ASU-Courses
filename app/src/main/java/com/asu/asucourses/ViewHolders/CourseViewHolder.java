package com.asu.asucourses.ViewHolders;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.activities.CoursesDetailsActivity;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.utils.Constants;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bumptech.glide.Glide;

public class CourseViewHolder extends ChildViewHolder implements View.OnClickListener {
    private TextView courseTitle;
    private Course course;
    ImageView imgView;

    public CourseViewHolder(View itemView) {
        super(itemView);
        courseTitle = itemView.findViewById(R.id.CourseTitletextView);
        imgView = itemView.findViewById(R.id.course_img);
        itemView.setOnClickListener(this);
    }

    public void bind(Course course) {
        this.course = course;
        courseTitle.setText(course.getCourseName());
        Glide.with(imgView).load(course.getCourseImageUrl()).into(imgView);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), CoursesDetailsActivity.class);
        String courseJson = Constants.serializeCourseToJson(course);
        i.putExtra("courseJson", courseJson);
        v.getContext().startActivity(i);
    }
}
