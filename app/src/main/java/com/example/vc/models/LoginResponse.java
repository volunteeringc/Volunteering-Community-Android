package com.example.vc.models;

public class LoginResponse {

    private String token, ID, message;



    public LoginResponse(String token, String ID, String message) {
        this.token = token;
        this.ID = ID;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
