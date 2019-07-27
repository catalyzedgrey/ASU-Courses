package com.asu.asucourses.itemviews;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.activities.CoursesDetailsActivity;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.utils.Constants;


public class CourseItem extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title;
    private Course course;


    public CourseItem(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.itemViewCourse);
    }

    public void bindCourse(final Course course) {
        this.course = course;
        title.setText(course.getCourseName());
    }

    @Override
    public void onClick(View v) {
        //sending course to courseDetailsActivity
        Intent i = new Intent(v.getContext(), CoursesDetailsActivity.class);
        String courseJson = Constants.serializeCourseToJson(course);
        i.putExtra("courseJson", courseJson);
        v.getContext().startActivity(i);

        //Send course details to CoursesDetailsActivity
   /*     i.putExtra("Course Name",course.getCourseName());
        i.putExtra("Course ID",course.getCourseId());
        i.putExtra("Course GPA",course.getMinGPA());
        i.putExtra("Course DESC",course.getCourseDescription());
        i.putExtra("Course URL",course.getCourseImageUrl());


        v.getContext().startActivity(i);*/
    }
}
