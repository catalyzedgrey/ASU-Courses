package com.asu.asucourses.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackResult {
    @SerializedName("tracks")
    private List<Track> tracksResult;

    public List<Track> getTracksResult() {
        return tracksResult;
    }

    public void setTracksResult(List<Track> tracksResult) {
        this.tracksResult = tracksResult;
    }
}
