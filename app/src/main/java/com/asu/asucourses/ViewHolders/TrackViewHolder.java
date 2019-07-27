package com.asu.asucourses.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.adapters.CourseAdapter;
import com.asu.asucourses.interfaces.IService;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.models.Instructor;
import com.asu.asucourses.models.Track;
import com.asu.asucourses.services.CoursesService;
import com.asu.asucourses.utils.Constants;

import java.util.List;

public class TrackViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, IService {
    private TextView trackTitle;
    CourseAdapter courseAdapter;
    Track track;
    View subItem;

    public TrackViewHolder(View itemView) {
        super(itemView);
        subItem = itemView.findViewById(R.id.subitem);
        trackTitle = itemView.findViewById(R.id.itemViewTrack);
        itemView.setOnClickListener(this);
    }


    public void bind(Track track, CourseAdapter adapter) {
        boolean expanded = track.isExpanded();
        courseAdapter = adapter;
        this.track = track;
        subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);
        subItem.setVisibility(View.VISIBLE);
        trackTitle.setText(track.getTrackName());
    }

    @Override
    public void onClick(View v) {
        new CoursesService(this).execute(Constants.coursesUrl);
        boolean expanded = track.isExpanded();
        track.setExpanded(!expanded);
        subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);
        courseAdapter.notifyItemChanged(this.getAdapterPosition());
    }

    @Override
    public void onTaskCompleted(List courseList) {
//        Course c = new Course("1", "Physics", "M", (float) 2.0, "5",
//                new Instructor("1", "Jhon", "k", "as", "asas"));
//        CourseList.add(c);
//        CourseList.add(c);
        courseAdapter.refreshCourseAdapter(courseList);
        courseAdapter.notifyItemChanged(this.getOldPosition());
    }
}
