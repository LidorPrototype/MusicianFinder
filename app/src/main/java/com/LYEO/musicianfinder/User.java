package com.LYEO.musicianfinder;

import java.util.ArrayList;
import java.util.List;

public class User {
/*
* Created by Yisrael Bar & Lidor Eliyahu on 24/09/2020
* */
    private String UserName, UserPass , Name, UserLocation, UserBio , UserLink;
    private List<String> UserInstruments;
    private List<String> UserGenres;
    private ArrayList<Boolean> genresCheckedItems = new ArrayList<>();  /* No Need in toString() */
    private int UserAge ;

    public User(String userName, String userPass, String name, String location,
                    String userBio, List<String> genres, ArrayList<Boolean> _checked, List<String> instruments,
                    String userLink, int userAge
                ){
        this.UserName = userName;
        this.UserPass = userPass;
        this.Name = name;
        this.UserLocation = location;
        this.UserBio = userBio;
        this.UserGenres = genres;
        this.genresCheckedItems = _checked;
        this.UserInstruments = instruments;
        this.UserLink = userLink;
        this.UserAge = userAge;
    }

    public User (){
        this.UserName = "";
        this.UserPass = "";
        this.Name = "";
        this.UserLocation = "";
        this.UserBio = "";
        this.UserGenres = new ArrayList<>();
        this.genresCheckedItems = new ArrayList<>();
        this.UserInstruments = new ArrayList<>();
        this.UserLink = "";
        this.UserAge = 0;
    }

    public ArrayList<Boolean> getGenresCheckedItems() {
        return genresCheckedItems;
    }
    public List<String> getUserGenres() {
        return UserGenres;
    }
    public void setUserGenres(List<String> userGenres) {
        UserGenres = userGenres;
    }
    public List<String> getUserInstruments() {
        return UserInstruments;
    }
    public void setUserInstruments(List<String> userInstruments) {
        UserInstruments = userInstruments;
    }
    public String getUserLocation() {
        return UserLocation;
    }
    public void setUserLocation(String userLocation) {
        UserLocation = userLocation;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public String getUserPass() {
        return UserPass;
    }
    public void setUserPass(String userPass) {
        UserPass = userPass;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getUserBio() {
        return UserBio;
    }
    public void setUserBio(String userBio) {
        UserBio = userBio;
    }
    public String getUserLink() {
        return UserLink;
    }
    public void setUserLink(String userLink) {
        UserLink = userLink;
    }
    public int getUserAge() {
        return UserAge;
    }
    public void setUserAge(int userAge) {
        UserAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName = '" + UserName + '\'' +
                ", UserPass = '" + UserPass + '\'' +
                ", Name = '" + Name + '\'' +
                ", Location = '" + UserLocation + '\'' +
                ", UserBio = '" + UserBio + '\'' +
                ", Genres = '" + UserGenres.toString() + '\'' +
                ", Instruments = '" + UserInstruments.toString() + '\'' +
                ", UserLink = '" + UserLink + '\'' +
                ", UserAge = " + UserAge +
                '}';
    }
}
