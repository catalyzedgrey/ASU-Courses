package com.asu.asucourses.models;

import com.google.gson.annotations.SerializedName;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Track extends ExpandableGroup<Course> {

    @SerializedName("id")
    private String trackId;
    @SerializedName("name")
    private String trackName;

//    public Track(String trackId, String trackName) {
//        this.trackId = trackId;
//        this.trackName = trackName;
//    }

    public Track(String title, List<Course> items) {
        super(title, items);
        trackName = title;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
}
