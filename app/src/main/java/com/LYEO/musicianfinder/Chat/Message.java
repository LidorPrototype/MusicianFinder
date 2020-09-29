package com.LYEO.musicianfinder.Chat;/*
 * created by yisrael bar
 */

import java.util.Calendar;

public class Message {
//    private int id;
    private String self_name;
    private String other_name;

    private String date;
    private String messeage;
    Calendar c=Calendar.getInstance();



    public Message( String self_name, String other_name, String messeage) {
//        this.id = id;
        this.self_name = self_name;
        this.other_name = other_name;
        this.date = String.valueOf(c.getTime());
        this.messeage = messeage;
    }
    public Message() {
//        this.id = 0;
        this.self_name = "";
        this.other_name = "";
        this.date = String.valueOf(c.getTime());
        this.messeage = "";
    }
    @Override
    public String toString() {
        return "Message{" +
                ", self_name='" + self_name + '\'' +
                ", other_name='" + other_name + '\'' +
                ", date='" + date + '\'' +
                ", messeage='" + messeage + '\'' +
                '}';
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getSelf_name() {
        return self_name;
    }

    public void setSelf_name(String self_name) {
        this.self_name = self_name;
    }

    public String getOther_name() {
        return other_name;
    }

    public void setOther_name(String other_name) {
        this.other_name = other_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMesseage() {
        return messeage;
    }

    public void setMesseage(String messeage) {
        this.messeage = messeage;
    }
}