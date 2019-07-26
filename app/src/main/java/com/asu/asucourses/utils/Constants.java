package com.asu.asucourses.utils;

import com.asu.asucourses.models.Course;
import com.asu.asucourses.models.Instructor;
import com.google.gson.Gson;

public abstract class Constants {
    public static final String trackUrl = "http://jsonstub.com/load-tracks";
    public static final String coursesUrl = "http://jsonstub.com/load-courses";

    public static String serializeCourseToJson(Course course){
        return (new Gson()).toJson(course);
    }

    public static Course deserializeCourseFromJson(String courseJson){
        return new Gson().fromJson(courseJson, Course.class);
    }

    public static String serializeInstructorToJson(Instructor instructor){
        return (new Gson()).toJson(instructor);
    }

    public static Instructor deserializeInstructorFromJson(String instructorJson){
        return new Gson().fromJson(instructorJson, Instructor.class);
    }
}
