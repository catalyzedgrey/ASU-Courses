package com.asu.asucourses.utils;

import com.asu.asucourses.application.User;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.models.Instructor;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class Constants {
    public static final String trackUrl = "http://3.80.183.111/app/api/getTrack.php";
    public static final String coursesUrl = "http://3.80.183.111/app/api/getCourse.php";
    public static final String addCourseUrl = "http://3.80.183.111/app/api/addCourse.php";
    public static final String dropCourseUrl = "http://3.80.183.111/app/api/dropCourse.php";
    public static final String registerUrl = "http://3.80.183.111/app/api/register.php";

    public static String serializeUserToJson(User user) {
        return (new Gson()).toJson(user);
    }

    public static User deserializeUserFromJson(String userJson) {
        return new Gson().fromJson(userJson, User.class);
    }


    public static String serializeCourseToJson(Course course) {
        return (new Gson()).toJson(course);
    }

    public static Course deserializeCourseFromJson(String courseJson) {
        return new Gson().fromJson(courseJson, Course.class);
    }

    public static String serializeInstructorToJson(Instructor instructor) {
        return (new Gson()).toJson(instructor);
    }

    public static Instructor deserializeInstructorFromJson(String instructorJson) {
        return new Gson().fromJson(instructorJson, Instructor.class);
    }

    public static String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}
