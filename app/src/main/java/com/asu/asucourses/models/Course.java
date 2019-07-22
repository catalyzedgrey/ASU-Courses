package com.asu.asucourses.models;

public class Course {
    private String courseId;
    private String courseName;
    private String courseDescription;
    private float minGPA;
    private String coueseInageUrl;
    private Instructor instructor;

    public Course(String courseId, String courseName, String courseDescription, float minGPA, String coueseInageUrl, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.minGPA = minGPA;
        this.coueseInageUrl = coueseInageUrl;
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

    public String getCoueseInageUrl() {
        return coueseInageUrl;
    }

    public void setCoueseInageUrl(String coueseInageUrl) {
        this.coueseInageUrl = coueseInageUrl;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
