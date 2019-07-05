package com.example.vc.models;

public class User {


    private String id ,email, name , token, password;


    public User(String id, String token) {
        this.id = id;
        this.token = token;
    }


    public User(String id, String email, String name, String token, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.token = token;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
