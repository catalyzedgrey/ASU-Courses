package com.asu.asucourses.activities;

import android.view.View;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.models.Course;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class CourseViewHolder extends ChildViewHolder {

    private TextView courseTitle;

    public CourseViewHolder(View itemView) {
        super(itemView);
        courseTitle = itemView.findViewById(R.id.itemViewCourse);
    }

    public void bind(Course course) {
        courseTitle.setText(course.getCourseName());
    }
}
