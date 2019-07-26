package com.asu.asucourses.itemviews;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.activities.CoursesDetailsActivity;
import com.asu.asucourses.activities.CoursesListActivity;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.utils.Constants;
//import com.asu.asucourses.interfaces.OnItemClickListener;


public class CourseItem extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title;
    Course course;

    public CourseItem(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.itemViewCourse);
        itemView.setOnClickListener(this);
    }

    //    public void bindCourse(final Course course, final OnItemClickListener listener) {
//        title.setText(course.getCourseName());
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onCourseClick(course);
//            }
//        });
//    }
    public void bindCourse(final Course course) {
        this.course = course;
        title.setText(course.getCourseName());

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), CoursesDetailsActivity.class);
        //Send course details to CoursesDetailsActivity

        v.getContext().startActivity(i);
    }
}
