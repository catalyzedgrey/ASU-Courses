package com.asu.asucourses.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asu.asucourses.R;
import com.asu.asucourses.ViewHolders.CourseViewHolder;
import com.asu.asucourses.ViewHolders.TrackViewHolder;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.models.Track;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ExpandableAdapter extends ExpandableRecyclerViewAdapter<TrackViewHolder, CourseViewHolder> {

    public ExpandableAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public TrackViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_track_item, parent, false);
        return new TrackViewHolder(view);
    }

    @Override
    public CourseViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_course_item, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(CourseViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Course course = (Course) group.getItems().get(childIndex);
        holder.bind(course);

    }

    @Override
    public void onBindGroupViewHolder(TrackViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Track track = (Track) group;
        holder.bind(track);

    }
}
