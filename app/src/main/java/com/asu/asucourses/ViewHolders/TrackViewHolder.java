package com.asu.asucourses.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asu.asucourses.R;
import com.asu.asucourses.adapters.CourseAdapter;
import com.asu.asucourses.adapters.TrackAdapter;
import com.asu.asucourses.interfaces.IService;
import com.asu.asucourses.interfaces.ItemExpandedListener;
import com.asu.asucourses.models.Track;
import com.asu.asucourses.services.CoursesService;
import com.asu.asucourses.utils.Constants;

import java.util.List;

public class TrackViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, IService {
    private TextView trackTitle;
    private CourseAdapter courseAdapter;
    private TrackAdapter trackAdapter;
    private Track track;
    private View subItem;
    private ImageView expandImgView;
    private ItemExpandedListener listener;

    public TrackViewHolder(View itemView) {
        super(itemView);
        subItem = itemView.findViewById(R.id.subitem);
        trackTitle = itemView.findViewById(R.id.itemViewTrack);
        expandImgView = itemView.findViewById(R.id.expand_img_view);
        itemView.setOnClickListener(this);
    }


    public void bind(Track track, CourseAdapter adapter, TrackAdapter trackAdapter) {
        boolean expanded = track.isExpanded();
        courseAdapter = adapter;
        this.trackAdapter = trackAdapter;
        this.track = track;
        subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);
        trackTitle.setText(track.getTrackName());
    }

    @Override
    public void onClick(View v) {
        new CoursesService(this).execute(Constants.coursesUrl);
        boolean expanded = track.isExpanded();
        track.setExpanded(!expanded);
        subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);
        listener.onExpandListener(this.getAdapterPosition());
        trackAdapter.notifyItemChanged(this.getAdapterPosition());
        //courseAdapter.notifyItemChanged(this.getAdapterPosition());
    }

    @Override
    public void onTaskCompleted(List courseList) {
//        Course c = new Course("1", "Physics", "M", (float) 2.0, "5",
//                new Instructor("1", "Jhon", "k", "as", "asas"));
//        CourseList.add(c);
//        CourseList.add(c);
//        expandImgView.animate().rotation(expandImgView.getRotation()+180);
        expandImgView.animate().rotation(expandImgView.getRotation()+180);
        courseAdapter.refreshCourseAdapter(courseList);
        trackAdapter.notifyItemChanged(this.getOldPosition());
    }

    public void setCustomObjectListener(ItemExpandedListener listener) {
        this.listener = listener;
    }

    public View getSubItem() {
        return subItem;
    }
}
