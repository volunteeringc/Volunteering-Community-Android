package com.example.vc.models;

public class FollowersResponse {
    public FollowersResponse() {
    }

    String followers[];

    public FollowersResponse(String[] followers) {
        this.followers = followers;
    }

    public String[] getFollowers() {
        return followers;
    }

    public void setFollowers(String[] followers) {
        this.followers = followers;
    }
}
