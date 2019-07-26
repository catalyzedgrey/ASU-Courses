package com.asu.asucourses.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asu.asucourses.R;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.itemviews.CourseItem;
//import com.asu.asucourses.interfaces.OnItemClickListener;

import java.util.List;

public class CourseAdapter  extends RecyclerView.Adapter<CourseItem>  {
    private List<Course> courses;
//    private OnItemClickListener listener;

//    public CourseAdapter(OnItemClickListener listener) {
//        this.listener = listener;
//    }

    public CourseAdapter() {
    }

    @NonNull
    @Override
    public CourseItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_course_item, viewGroup, false);
        return new CourseItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseItem courseItem, int i) {
//        courseItem.bindCourse(courses.get(i), listener);
        courseItem.bindCourse(courses.get(i));
    }

    @Override
    public int getItemCount() {
        return courses == null ? 0 : courses.size();
    }


    public void refreshCourseAdapter(List<Course> courses){
        this.courses = courses;
        notifyDataSetChanged();
    }

}
