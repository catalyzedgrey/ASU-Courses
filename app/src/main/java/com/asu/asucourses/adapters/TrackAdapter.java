package com.asu.asucourses.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asu.asucourses.itemviews.TrackItem;
import com.asu.asucourses.R;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.models.OnItemClickListener;
import com.asu.asucourses.models.Track;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackItem> implements OnItemClickListener {
    private List<Track> tracks;
    private OnItemClickListener listener;

    public TrackAdapter(List<Track> tracks, OnItemClickListener listener) {
        this.tracks = tracks;
        this.listener = listener;
    }

    public TrackAdapter() {
    }

    @NonNull
    @Override
    public TrackItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_track_item, viewGroup, false);
        return new TrackItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackItem trackItem, int i) {
        trackItem.bindTrack(tracks.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return tracks == null ? 0 : tracks.size();
    }


    public void refreshTrackAdapter(List<Track> tracks){
        this.tracks = tracks;
        notifyDataSetChanged();
    }

    @Override
    public void onCourseClick(Course item) {

    }
    @Override
    public void onTrackClick(Track item) {
        //open Track details
    }
}
