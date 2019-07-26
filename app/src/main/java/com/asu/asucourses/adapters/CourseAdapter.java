package com.asu.asucourses.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asu.asucourses.R;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.itemviews.CourseItem;
import com.asu.asucourses.interfaces.OnItemClickListener;
import com.asu.asucourses.models.Track;

import java.util.List;

public class CourseAdapter  extends RecyclerView.Adapter<CourseItem> implements OnItemClickListener {
    private List<Course> courses;
    private OnItemClickListener listener;

    public CourseAdapter(List<Course> courses, OnItemClickListener listener) {
        this.courses = courses;
        this.listener = listener;
    }

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
        courseItem.bindTrack(courses.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return courses == null ? 0 : courses.size();
    }


    public void refreshCourseAdapter(List<Course> courses){
        this.courses = courses;
        notifyDataSetChanged();
    }

    @Override
    public void onCourseClick(Course item) {
       //open course details
    }
    @Override
    public void onTrackClick(Track item) {
        //open course details
    }
}
