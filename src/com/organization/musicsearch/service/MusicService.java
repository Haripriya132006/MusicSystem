package com.organization.musicsearch.service;

import java.util.List;

import com.organization.musicsearch.exception.SongnotfoundException;
import com.organization.musicsearch.model.Artist;
import com.organization.musicsearch.repository.SongRepository;
import com.organization.musicsearch.repository.ArtistRepository;

public class MusicService {
    SongRepository songRepository;
    public MusicService(SongRepository songRepository){
        this.songRepository=songRepository;
    }

    public void trending()throws SongnotfoundException{
        System.out.println("Current Trending Songs");
        for (String song :songRepository.getSongsWithViewsGt(1000)){
            System.out.println(song);
        }

    }
    public void searchByArtists(String artist)throws SongnotfoundException{
        System.out.println("Songs of the artist " + artist);
        for(String song:songRepository.getSongByArtist(artist)){
            System.out.println(song);
        }
    }
    public void filterGener(String genre)throws SongnotfoundException{
        System.out.println("Songs in the genre " + genre);
        for(String song:songRepository.searchbygenre(genre)){
            System.out.println(song);
        }
    }   
}
