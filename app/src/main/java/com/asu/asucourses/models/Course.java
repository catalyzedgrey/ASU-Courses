package com.asu.asucourses.models;

import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("id")
    private String courseId;
    @SerializedName("name")
    private String courseName;
    @SerializedName("desc")
    private String courseDescription;
    @SerializedName("min_gpa")
    private float minGPA;
    @SerializedName("image_url")
    private String courseImageUrl;
    @SerializedName("instructor")
    private Instructor instructor;

    public Course(String courseId, String courseName, String courseDescription, float minGPA, String courseImageUrl, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.minGPA = minGPA;
        this.courseImageUrl = courseImageUrl;
        this.instructor = instructor;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public float getMinGPA() {
        return minGPA;
    }

    public void setMinGPA(float minGPA) {
        this.minGPA = minGPA;
    }

    public String getCourseImageUrl() {
        return courseImageUrl;
    }

    public void setCourseImageUrl(String courseImageUrl) {
        this.courseImageUrl = courseImageUrl;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
