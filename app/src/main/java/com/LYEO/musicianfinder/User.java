package com.LYEO.musicianfinder;

public class User {
/*
* Created by yisrael bar on 24/09/2020
* */
    private String UserName ,UserPass , Name , UserBio , UserLink ;
    private int UserAge ;

    public User (String userName ,String userPass ,String name ,String userBio ,String userLink,int userAge){
        this.UserName = userName;
        this.UserPass = userPass;
        this.Name = name;
        this.UserBio = userBio;
        this.UserLink = userLink;
        this.UserAge = userAge;
    }
    public User (){
        this.UserName = "";
        this.UserPass = "";
        this.Name = "";
        this.UserBio = "";
        this.UserLink = "";
        this.UserAge = 0;
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
                "UserName='" + UserName + '\'' +
                ", UserPass='" + UserPass + '\'' +
                ", Name='" + Name + '\'' +
                ", UserBio='" + UserBio + '\'' +
                ", UserLink='" + UserLink + '\'' +
                ", UserAge=" + UserAge +
                '}';
    }
}
