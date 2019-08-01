package com.asu.asucourses.application;

import android.app.Application;

import com.google.gson.annotations.SerializedName;

public class User extends Application {

    private String userId;
    @SerializedName("name")
    private String userName;
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;
    @SerializedName("gpa")
    private String gpa;
    @SerializedName("level")
    private String level;
    @SerializedName("gender")
    private String gender = "m";
    public static boolean isLogged = false;


    public User(String userName, String email, String password, String gpa, String level) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.level = level;
        this.gpa = gpa;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
