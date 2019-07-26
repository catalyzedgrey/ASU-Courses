package com.asu.asucourses.itemviews;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.activities.CoursesListActivity;
import com.asu.asucourses.activities.MainActivity;
//import com.asu.asucourses.interfaces.OnItemClickListener;
import com.asu.asucourses.models.Track;

public class TrackItem extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title;


    public TrackItem(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.itemViewTrack);
        itemView.setOnClickListener(this);
    }

//    public void bindTrack(final Track track, final OnItemClickListener listener) {
//        title.setText(track.getTrackName());
//    }

    public void bindTrack(final Track track) {
        title.setText(track.getTrackName());
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), CoursesListActivity.class);
        v.getContext().startActivity(i);
    }
}
