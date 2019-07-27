package com.asu.asucourses.ViewHolders;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.activities.CoursesDetailsActivity;
import com.asu.asucourses.models.Course;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.google.gson.Gson;

public class CourseViewHolder extends ChildViewHolder implements View.OnClickListener {
    private TextView courseTitle;
    private Course course;

    public CourseViewHolder(View itemView) {
        super(itemView);
        courseTitle = itemView.findViewById(R.id.itemViewCourse);
        itemView.setOnClickListener(this);
    }

    public void bind(Course course) {
        this.course = course;
        courseTitle.setText(course.getCourseName());
    }

    @Override
    public void onClick(View v) {
        String courseJson = (new Gson()).toJson(this.course);
        Intent i = new Intent(v.getContext(), CoursesDetailsActivity.class);
        i.putExtra("course", courseJson);
        v.getContext().startActivity(i);
    }
}
