package com.example.vc.models;

public class HomeResponse {
    public HomeResponse() {
    }
   String postsOfFollowing[];

    public String[] getPostsOfFollowing() {
        return postsOfFollowing;
    }

    public void setPostsOfFollowing(String[] postsOfFollowing) {
        this.postsOfFollowing = postsOfFollowing;
    }
}
