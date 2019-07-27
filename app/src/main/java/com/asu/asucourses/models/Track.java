package com.asu.asucourses.models;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Track implements Parent<Course> {

    @SerializedName("id")
    private String trackId;
    @SerializedName("name")
    private String trackName;

    private List<Course> courses;

    public Track(String trackId, String trackName, List<Course> courses) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.courses = courses;
    }

    @Override
    public List<Course> getChildList() {
        return courses;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
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
