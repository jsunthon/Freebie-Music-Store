package springmusic.model.dao.jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmusic.model.Album;
import springmusic.model.Genre;
import springmusic.model.Track;
import springmusic.model.dao.TrackDao;

@Repository
public class TrackDaoImpl implements TrackDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void delete(Track track) {
        em.remove(track);
    }

    @Override
    public List<Track> getComments(int id) {
        String query = "SELECT t FROM Track t WHERE t.comment.user.id = :id";
        return em.createQuery(query, Track.class).setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Track> getFeatureTracks() {
        String query = "FROM Track t WHERE t.feature = true ORDER BY t.name";
        return em.createQuery(query, Track.class).getResultList();
    }

    @Override
    public Map<Genre, List<Track>> getGenreTracksMap() {
        Map<Genre, List<Track>> tracks = new HashMap<Genre, List<Track>>();
        for (Genre genre : Genre.values()) {
            tracks.put(genre, getTracks(genre));
        }
        return tracks;
    }

    private List<Album> getRandomAlbumByGenre(Genre genre) {
        String query = "FROM Album a WHERE a.genre = ?1 ORDER BY RAND()";
        return em.createQuery(query, Album.class).setParameter(1, genre)
                .getResultList();
    }

    @Override
    public Map<Genre, List<Track>> getRandomGenreTracksMap() {
        Map<Genre, List<Track>> mapGenreTracks = new HashMap<Genre, List<Track>>();

        Random random = new Random();
        int randIndex;

        for (Genre genre : Genre.values()) {
            List<Track> tracks = new ArrayList<Track>();

            for (Album album : getRandomAlbumByGenre(genre)) {
                randIndex = random.nextInt(album.getTracks().size());
                tracks.add(album.getTracks().get(randIndex));
            }
            mapGenreTracks.put(genre, tracks);
        }
        return mapGenreTracks;
    }

    @Override
    public List<Track> getRandomTracks(int numOfTracks) {
        return em.createQuery("FROM Track ORDER BY rand()", Track.class)
                .setMaxResults(numOfTracks).getResultList();
    }

    @Override
    public List<Track> getTopTracks(int numOfTracks) {
        String query = "FROM Track t ORDER BY t.count DESC ";
        return em.createQuery(query, Track.class).setMaxResults(numOfTracks)
                .getResultList();
    }

    @Override
    public List<Track> getTopTracks(int numOfTracks, Genre genre) {
        String query = "FROM Track t WHERE t.album.genre = :genre ORDER BY t.count DESC ";
        return em.createQuery(query, Track.class).setParameter("genre", genre)
                .setMaxResults(numOfTracks).getResultList();
    }

    @Override
    public Track getTrack(int id) {
        return em.find(Track.class, id);
    }

    @Override
    public List<Track> getTracks() {
        String query = "FROM Track t ORDER BY t.album.artist.name";
        return em.createQuery(query, Track.class).getResultList();
    }

    @Override
    public List<Track> getTracks(Genre genre) {
        String query = "FROM Track t WHERE t.album.genre = ?1 ORDER BY t.album.name ASC";
        return em.createQuery(query, Track.class).setParameter(1, genre)
                .getResultList();

    }

    @Override
    @Transactional
    public Track save(Track track) {
        return em.merge(track);
    }

    @Override
    public List<Track> searchTrack(String searchTerm) {
        String query = "FROM Track t WHERE UPPER(t.name) LIKE  ?1 ";
        return em.createQuery(query, Track.class)
                .setParameter(1, "%" + searchTerm.toUpperCase() + "%")
                .getResultList();
    }
}
