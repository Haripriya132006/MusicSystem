package com.organization.musicsearch.model;

public class Song {
    private String songId;
    private String songName;
    private String artistName;
    private String genre;
    private int views;
    
    public Song(String songId, String songName, String artistName, String genre, int views) {
        this.songId = songId;
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.views = views;
    }

    public String getSongId() {
        return songId;
    }


    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getGenre() {
        return genre;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
    
    
}
