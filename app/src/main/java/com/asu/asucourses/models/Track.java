package com.asu.asucourses.models;

import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("id")
    private String trackId;
    @SerializedName("name")
    private String trackName;
    private boolean isExpanded = true;

    public Track(String trackId, String trackName) {
        this.trackId = trackId;
        this.trackName = trackName;
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

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean isExpanded) {
        this.isExpanded = isExpanded;
    }
}
