package springmusic.model.dao;

import java.util.List;

import springmusic.model.Artist;

public interface ArtistDao {

    List<Artist> getArtists();

    List<Artist> searchArtist(String searchTerm);

    Artist getArtist(int id);
    
    Artist save(Artist artist);

    void delete(Artist artist);
}
