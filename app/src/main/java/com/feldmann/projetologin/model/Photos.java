package com.feldmann.projetologin.model;

public class Photos {
    private int albumID;
    private int id;
    private String title;
    private String url;
    private String thumbnailURL;
    //
    public Photos(int albumID, int id, String title, String url, String thumbnailURL) {
        this.albumID = albumID;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailURL = thumbnailURL;
    }
    //
    public int getAlbumID() { return albumID; }
    public void setAlbumID(int albumID) { this.albumID = albumID; }
    //
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    //
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    //
    public String getUrl() { return url; }
    //
    public String getThumbnailURL() { return thumbnailURL; }
}
