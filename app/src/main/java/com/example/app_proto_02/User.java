package com.example.app_proto_02;

import com.google.firebase.database.Exclude;

public class User {
    public String UserName;
    public String Email;


    public User() {

    }

    public User(String userName, String email) {
        this.UserName = userName;
        this.Email = email;
    }

    @Exclude
    public String getUserName() {
        return UserName;
    }

    @Exclude
    public void setUserName(String userName) {
        UserName = userName;
    }

    @Exclude
    public String getEmail() {
        return Email;
    }

    @Exclude
    public void setEmail(String email) {
        Email = email;
    }

}

