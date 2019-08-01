package com.asu.asucourses.models;

import com.asu.asucourses.application.User;
import com.google.gson.annotations.SerializedName;

public class AccountResult {
    @SerializedName("status")
    private int resultstatus;
    @SerializedName("message")
    private String resultMessage;
    @SerializedName("account")
    private User user;
    // {"status":0,"message":"User created","account":{"id":"19","name":"John","email":"j@gmail.com","level":"3","gpa":"3","gender":"m"}}
    // {"status":3,"message":"email already registered"}


    public int getResultstatus() {
        return resultstatus;
    }

    public void setResultstatus(int resultstatus) {
        this.resultstatus = resultstatus;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
