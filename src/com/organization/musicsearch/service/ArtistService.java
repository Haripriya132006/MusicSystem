package com.organization.musicsearch.service;

import com.organization.musicsearch.model.Artist;
import com.organization.musicsearch.model.Song;
import com.organization.musicsearch.repository.SongRepository;

public class ArtistService {
    static Integer counter=1;
    Artist artist;

    SongRepository songRepository;
    ArtistService(Artist artist,SongRepository songRepository){
        this.artist=artist;
        this.songRepository=songRepository;
    }

    public int viewsgenerator(int counter){
        return (int)(counter*125.43256);
    }

    public void addsong(String songname,String genre){
        
        songRepository.add(new Song("song"+String.valueOf(counter), songname, artist.getName(), genre, viewsgenerator(counter)));
    }
}
