package com.organization.musicsearch.model;

public class Artist {
    private String artistId;
    private String name;
    private String description;
    private String gmail;
    public Artist(String artistId, String name, String description, String gmail) {
        this.artistId = artistId;
        this.name = name;
        this.description = description;
        this.gmail = gmail;
    }
    public String getArtistId() {
        return artistId;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getGmail() {
        return gmail;
    }

}
