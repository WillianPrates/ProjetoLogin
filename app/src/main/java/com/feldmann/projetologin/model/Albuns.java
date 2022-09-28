package com.feldmann.projetologin.model;

public class Albuns {
    private int userID;
    private int id;
    private String title;
    //
    public Albuns(int userID, int id, String title) {
        this.userID = userID;
        this.id = id;
        this.title = title;
    }
    //
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
    //
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    //
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
