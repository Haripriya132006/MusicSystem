import java.util.Scanner;

import com.organization.musicsearch.exception.ArtistnotfoundException;
import com.organization.musicsearch.exception.SongnotfoundException;
import com.organization.musicsearch.model.*;
import com.organization.musicsearch.repository.SongRepository;
import com.organization.musicsearch.repository.ArtistRepository;
import com.organization.musicsearch.service.ArtistService;
import com.organization.musicsearch.service.MusicService;

public class App {
    public static void main(String[] args) throws Exception {

        SongRepository songRepository=new SongRepository();
        songRepository.add(new Song("S1","Catterpiller","Hp","Pop",100));
        songRepository.add(new Song ("S2","Neon","rivan","Lofi",1100));
        songRepository.add(new Song ("S3","Swim","bts","Pop",6200));
        songRepository.add(new Song ("S7","dynamite","bts","Pop",1400));
        songRepository.add(new Song ("S4","Moments","1d","r/B",6200));
        songRepository.add(new Song ("S5","Dejavu","txt","Pop",100));
        songRepository.add(new Song ("S6","pewpew","BTS","lofi",900));
        
        MusicService service=new MusicService(songRepository);
        Scanner sc=new Scanner(System.in);
        System.out.println("Music system");
        System.out.println("--------------------");
        
        System.out.println("choose an option on what you would like to see");
        System.out.println("1 -> See Trending songs");
        System.out.println("2 -> View songs of an artist");
        System.out.println("3 -> Filterby genre");
        System.out.println("4 -> Artist workspace");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                service.trending();
                break;
            case 2:
                System.out.println("Enter artist's name: ");
                try{
                    String artist=sc.next();
                    service.searchByArtists(artist); 
                }
                catch (SongnotfoundException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.print("Enter genre :");
                String genre=sc.next();
                try{
                    service.filterGener(genre);
                }
                catch (SongnotfoundException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                System.out.println("Artist workSpace");
                try{
                    System.out.println("Enter Artist Id - case sensitive");
                    String id=sc.next();
                    artistview(id,songRepository);
                }
                catch (ArtistnotfoundException e){
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalic choice");
                break;
        }
        sc.close();
    }
    // checking adding songs by artist
    public static void artistview(String id,SongRepository songRepository) throws ArtistnotfoundException{
        ArtistRepository artistRepository=new ArtistRepository();
        artistRepository.add(new Artist("A1", "hp", "hello", "hp@gmail.com"));
        artistRepository.add(new Artist("A2", "ts", "bye", "ts@gmail.com"));
        ArtistService artistService=new ArtistService(artistRepository.fetchUser(id),songRepository);
        System.out.println("Hello Artist "+artistRepository.fetchUser(id).getName());
        System.out.println("Enter songname");
        System.out.println("Enter Genre");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        String genre=sc.nextLine();
        artistService.addsong(name, genre);
    }
}
