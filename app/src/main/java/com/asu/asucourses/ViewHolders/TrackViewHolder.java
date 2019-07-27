package com.asu.asucourses.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.models.Track;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;

public class TrackViewHolder extends ParentViewHolder {
    private TextView trackTitle;

    public TrackViewHolder(View itemView) {
        super(itemView);

        trackTitle = itemView.findViewById(R.id.itemViewTrack);
    }

    public void bind(Track track) {
        trackTitle.setText(track.getTrackName());
    }
}
