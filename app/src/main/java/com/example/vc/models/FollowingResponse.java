package com.example.vc.models;

public class FollowingResponse {
    public FollowingResponse() {
    }

    String following[];

    public FollowingResponse(String[] following) {
        this.following = following;
    }

    public String[] getFollowing() {
        return following;
    }

    public void setFollowing(String[] following) {
        this.following = following;
    }
}
