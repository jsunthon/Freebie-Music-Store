package springmusic.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmusic.model.Album;
import springmusic.model.dao.AlbumDao;

@Repository
public class AlbumDaoImpl implements AlbumDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void delete(Album album) {
        em.remove(album);
    }

    @Override
    public Album getAlbum(int id) {
        return em.find(Album.class, id);
    }

    @Override
    public List<Album> getAlbums() {
        return em.createQuery("FROM Album a", Album.class).getResultList();
    }

    @Override
    @Transactional
    public Album save(Album album) {
        return em.merge(album);
    }

    @Override
    public List<Album> searchAlbum(String searchTerm) {
        String query = "FROM Album a WHERE UPPER(a.name) LIKE  ?1 ";
        return em.createQuery(query, Album.class)
                .setParameter(1, "%" + searchTerm.toUpperCase() + "%")
                .getResultList();
    }
}
