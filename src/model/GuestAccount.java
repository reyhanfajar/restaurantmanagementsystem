package com.example.restaurantmanagementsystem.Model;

public class GuestAccount {

    private String userName;
    private String password;

    public GuestAccount (String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
