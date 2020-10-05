package com.LYEO.musicianfinder.Posts;/*
 * created by yisrael bar
 */

public class Post {
    private String userName;
    private String content;
    private String location;
    private String instrument;

    public Post(){
        userName = "yakov";
        content = "test bla bla";
        location = "jerusalem";
        instrument = "bass";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
}
