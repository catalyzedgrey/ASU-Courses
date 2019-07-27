package com.asu.asucourses.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asu.asucourses.R;
import com.asu.asucourses.ViewHolders.CourseViewHolder;
import com.asu.asucourses.ViewHolders.TrackViewHolder;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.models.Track;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;

import java.util.List;


public class ExpandableAdapter extends ExpandableRecyclerAdapter<Track, Course, TrackViewHolder, CourseViewHolder> {

    private LayoutInflater Inflater;


    public ExpandableAdapter(Context context, @NonNull List<Track> parentList) {
        super(parentList);
        this.Inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TrackViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View view = Inflater.inflate(R.layout.activity_track_item, parentViewGroup, false);
        return new TrackViewHolder(view);
    }

    @Override
    public CourseViewHolder onCreateChildViewHolder(ViewGroup childViewGroup, int viewType) {
        View view = Inflater.inflate(R.layout.activity_course_item, childViewGroup, false);
        return new CourseViewHolder(view);
    }


    @Override
    public void onBindParentViewHolder(@NonNull TrackViewHolder parentViewHolder, int parentPosition, @NonNull Track parent) {
        parentViewHolder.bind(parent);
    }

    @Override
    public void onBindChildViewHolder(@NonNull CourseViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull Course child) {
        childViewHolder.bind(child);
    }

    public void refreshParent() {
        notifyParentDataSetChanged(true);
        // Parent Changes
//        notifyParentInserted(int parentPosition)
//        notifyParentRemoved(int parentPosition)
//        notifyParentChanged(int parentPosition)
//        notifyParentMoved(int fromParentPosition, int toParentPosition)
//        notifyParentRangeInserted(int parentPositionStart, int itemCount)
//        notifyParentRangeRemoved(int parentPositionStart, int itemCount)
//        notifyParentRangeChanged(int parentPositionStart, int itemCount)

    }

    public void refreshChild() {
        // Child Changes
//        notifyChildInserted(int parentPosition, int childPosition)
//        notifyChildRemoved(int parentPosition, int childPosition)
//        notifyChildChanged(int parentPosition, int childPosition)
//        notifyChildMoved(int parentPosition, int fromChildPosition, int toChildPosition)
//        notifyChildRangeInserted(int parentPosition, int childPositionStart, int itemCount)
//        notifyChildRangeRemoved(int parentPosition, int childPositionStart, int itemCount)
//        notifyChildRangeChanged(int parentPosition, int childPositionStart, int itemCount)

// Unspecific Change (not recommended, use above specific methods instead)
//        notifyParentDataSetChanged(boolean preserveExpansionState)


    }


}
