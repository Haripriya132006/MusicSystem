package com.organization.musicsearch.repository;
import java.util.HashMap;

import com.organization.musicsearch.exception.ArtistnotfoundException;
import com.organization.musicsearch.model.Artist;
public class ArtistRepository {

    private HashMap<String ,Artist> artists=new HashMap<>();

    public void add(Artist user){
        artists.put(user.getArtistId(),user);
    }
    public boolean exists(String userId){
        return artists.containsKey(userId);
    }
    public Artist fetchUser(String userId) throws ArtistnotfoundException{
        if(artists.containsKey(userId)==false) throw new ArtistnotfoundException("User not found");
        return artists.get(userId);
    }
}
