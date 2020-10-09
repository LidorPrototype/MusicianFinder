package com.LYEO.musicianfinder.Posts;/*
 * created by yisrael bar
 */

public class Post {
    private String userName = "";
    private String content = "";
    private String location = "";
    private String instrument = "";
    private boolean itIsABand ;
    private String genre;



    //empty constructor
    public Post(){
        userName = "yakov";
        content = "test bla bla";
        location = "jerusalem";
        instrument = "bass";
        itIsABand = false;
        genre = "jezz";
    }

    public Post(String userName, String content, String location, String instrument, boolean itIsABand, String genre) {
        this.userName = userName;
        this.content = content;
        this.location = location;
        this.instrument = instrument;
        this.itIsABand = itIsABand;
        this.genre = genre;
    }



    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //get replaced the is
    public boolean getItIsABand() {
        return itIsABand;
    }

    public void setItIsABand(boolean itIsABand) {
        this.itIsABand = itIsABand;
    }

    public String getUserName() {
        return userName == null ? "" : userName;
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
