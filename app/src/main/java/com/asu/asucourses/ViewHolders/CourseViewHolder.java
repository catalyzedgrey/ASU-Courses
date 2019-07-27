package com.asu.asucourses.ViewHolders;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.activities.CoursesDetailsActivity;
import com.asu.asucourses.models.Course;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class CourseViewHolder extends ChildViewHolder implements View.OnClickListener {

    private TextView courseTitle;

    public CourseViewHolder(View itemView) {
        super(itemView);
        courseTitle = itemView.findViewById(R.id.itemViewCourse);
        itemView.setOnClickListener(this);
    }

    public void bind(Course course) {
        courseTitle.setText(course.getCourseName());
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), CoursesDetailsActivity.class);
        //Send course details to CoursesDetailsActivity

        v.getContext().startActivity(i);
    }
}
