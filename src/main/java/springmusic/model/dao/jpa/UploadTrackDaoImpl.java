package springmusic.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmusic.model.UploadTrack;
import springmusic.model.User;
import springmusic.model.dao.UploadTrackDao;

@Repository
public class UploadTrackDaoImpl implements UploadTrackDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UploadTrack getUploadTrack(int id) {
        return em.find(UploadTrack.class, id);
    }

    @Override
    public List<UploadTrack> getUploadTracks() {
        String query = "FROM UploadTrack u ORDER BY u.name";
        return em.createQuery(query, UploadTrack.class).getResultList();
    }

    @Override
    public List<UploadTrack> getUploadTracks(User user) {
        String query = "FROM UploadTrack u WHERE u.user = :user ORDER BY u.name";
        return em.createQuery(query, UploadTrack.class)
                .setParameter("user", user).getResultList();
    }

    @Override
    @Transactional
    public UploadTrack save(UploadTrack uploadTrack) {
        return em.merge(uploadTrack);
    }

    @Override
    @Transactional
    public void remove(UploadTrack uploadTrack) {
        em.remove(uploadTrack);
    }

}
