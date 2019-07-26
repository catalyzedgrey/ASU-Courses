package com.asu.asucourses.models;

import com.google.gson.annotations.SerializedName;

public class Instructor {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String instructorName;
    @SerializedName("image_url")
    private String instructorImageUrl;
    @SerializedName("email")
    private String email;
    @SerializedName("bio")
    private String bio;

    public Instructor(String id, String instructorName, String instructorImageUrl, String email, String bio) {
        this.id = id;
        this.instructorName = instructorName;
        this.instructorImageUrl = instructorImageUrl;
        this.email = email;
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorImageUrl() {
        return instructorImageUrl;
    }

    public void setInstructorImageUrl(String instructorImageUrl) {
        this.instructorImageUrl = instructorImageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
