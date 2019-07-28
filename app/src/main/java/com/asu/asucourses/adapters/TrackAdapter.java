package com.asu.asucourses.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asu.asucourses.R;
import com.asu.asucourses.ViewHolders.TrackViewHolder;
import com.asu.asucourses.models.Track;

import java.util.List;

//import com.asu.asucourses.interfaces.OnItemClickListener;

public class TrackAdapter extends RecyclerView.Adapter<TrackViewHolder> {
    private List<Track> tracks;
    Context context;
//    private OnItemClickListener listener;

//    public TrackAdapter(OnItemClickListener listener) {
//        this.listener = listener;
//    }

    public TrackAdapter() {
    }

    @NonNull
    @Override
    public TrackViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_track_item, viewGroup, false);
        context = itemView.getContext();
        return new TrackViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder trackViewHolder, int i) {
        CourseAdapter courseAdapter = new CourseAdapter();
        RecyclerView recyclerView = trackViewHolder.itemView.findViewById(R.id.subitem);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL));
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(courseAdapter);
        trackViewHolder.bind(tracks.get(i), courseAdapter, this);

    }


    @Override
    public int getItemCount() {
        return tracks == null ? 0 : tracks.size();
    }


    public void refreshTrackAdapter(List<Track> tracks) {
        this.tracks = tracks;
        notifyDataSetChanged();
    }

}
