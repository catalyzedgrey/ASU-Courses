package com.asu.asucourses.itemviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.interfaces.OnItemClickListener;
import com.asu.asucourses.models.Track;

public class TrackItem extends RecyclerView.ViewHolder {

    private TextView title;


    public TrackItem(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.itemViewTrack);
    }

    public void bindTrack(final Track track, final OnItemClickListener listener) {
        title.setText(track.getTrackName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTrackClick(track);
            }
        });
    }
}
