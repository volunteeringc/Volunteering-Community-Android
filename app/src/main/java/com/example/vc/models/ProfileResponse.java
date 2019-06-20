package com.example.vc.models;


public class ProfileResponse {

    private String name, id;
    private String post[], event[], following[], followers[];

    public ProfileResponse(String name, String id, String[] post, String[] event, String[] following, String[] followers) {
        this.name = name;
        this.id = id;
        this.post = post;
        this.event = event;
        this.following = following;
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getPost() {
        return post;
    }

    public void setPost(String[] post) {
        this.post = post;
    }

    public String[] getEvent() {
        return event;
    }

    public void setEvent(String[] event) {
        this.event = event;
    }

    public String[] getFollowing() {
        return following;
    }

    public void setFollowing(String[] following) {
        this.following = following;
    }

    public String[] getFollowers() {
        return followers;
    }

    public void setFollowers(String[] followers) {
        this.followers = followers;
    }
}
