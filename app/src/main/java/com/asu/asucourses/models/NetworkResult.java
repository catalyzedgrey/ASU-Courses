package com.asu.asucourses.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NetworkResult {
    @SerializedName("tracks")
    List<Track> trackList;
    @SerializedName("courses")
    List<Course> courseList;

    public NetworkResult(){
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
