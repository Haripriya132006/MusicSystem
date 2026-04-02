package com.organization.musicsearch.repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import com.organization.musicsearch.exception.SongnotfoundException;
import com.organization.musicsearch.model.Song;

public class SongRepository {
    private HashMap<String ,Song> songs=new HashMap<>();
    public void add(Song song){
        songs.put(song.getSongId(),song);
    }
    public String getSongidFromName(String songName)throws SongnotfoundException{
        for(String id:songs.keySet()){
            Song song=songs.get(id);
            if(song.getSongName().equalsIgnoreCase(songName))
                return song.getSongId();
        }
        throw new SongnotfoundException(songName+" Not found in the system");
    }

    public Song fetch(String songId) throws SongnotfoundException{
        if(songs.containsKey(songId)==false) throw new SongnotfoundException("Song not found");
        return songs.get(songId);
    }

    public List<String> getSongsWithViewsGt(int views) throws SongnotfoundException{
        List<String> res=new ArrayList<>();
        for(String id:songs.keySet()){
            Song song=songs.get(id);
            if(song.getViews()>=views)
                res.add(song.getSongName()+" By "+song.getArtistName());
        }
        if(res.isEmpty()) throw new  SongnotfoundException("No trending songs");

        return res;
    }
    
    public List<String> getSongByArtist(String Artist)throws SongnotfoundException{
        List<String> songbyartist=new ArrayList<>();
        for(String id:songs.keySet()){
            Song song=songs.get(id);
            if(song.getArtistName().equalsIgnoreCase(Artist)){
                songbyartist.add(song.getSongName());
            }

        }     
        if(songbyartist.isEmpty()) throw new  SongnotfoundException("Song of the artist not found");
   
        return songbyartist;
    }
    
    public List<String> searchbygenre(String genre)throws SongnotfoundException{
        List<String> songsbygenre=new ArrayList<>();
        for(String id:songs.keySet()){
            Song song=songs.get(id);
            if(song.getGenre().equalsIgnoreCase(genre)){
                songsbygenre.add(song.getSongName());
            }

        }  
        if(songsbygenre.isEmpty()) throw new  SongnotfoundException("Song of the genre not found");
        return songsbygenre;
    }

}
