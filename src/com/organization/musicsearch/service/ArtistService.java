package com.organization.musicsearch.service;

import com.organization.musicsearch.model.Artist;
import com.organization.musicsearch.model.Song;
import com.organization.musicsearch.repository.SongRepository;

public class ArtistService {
    static Integer counter=1;
    Artist artist;

    SongRepository songRepository;
    public ArtistService(Artist artist,SongRepository songRepository){
        this.artist=artist;
        this.songRepository=songRepository;
    }

    public int viewsgenerator(int counter){
        return (int)Math.random()*1000;
    }

    public void addsong(String songname,String genre){
        int views=viewsgenerator(counter);
        songRepository.add(new Song("song"+String.valueOf(counter), songname, artist.getName(), genre, views));
        System.out.println("Song "+songname + " is added successfully with views "+ views);
    }
}
