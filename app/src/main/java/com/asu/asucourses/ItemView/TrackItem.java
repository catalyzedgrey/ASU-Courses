package com.asu.asucourses.ItemView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.models.Track;

public class TrackItem extends RecyclerView.ViewHolder {

    private TextView title;

    public TrackItem(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.itemViewTrack);
    }

    public void bindTrack(Track track) {
        title.setText(track.getTrackName());
    }
}
