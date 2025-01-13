package com.example.ap_assignment_4;

abstract class user{
    protected String username;

    public user(String username){
        this.username = username;
    }

    public boolean check_credentials(String username){
        return this.username.equals(username);
    }
}