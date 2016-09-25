package springmusic.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmusic.model.Comment;
import springmusic.model.Track;
import springmusic.model.User;
import springmusic.model.dao.CommentDao;

@Repository
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> getComments() {
        return em.createQuery("FROM Comment", Comment.class).getResultList();
    }

    @Override
    public Comment getComment(int id) {
        return em.find(Comment.class, id);
    }

    @Override
    public List<Comment> getComments(Track track) {
        String query = "FROM Comment c WHERE c.track.id = ?";
        return em.createQuery(query, Comment.class)
                .setParameter(1, track.getId()).getResultList();
    }

    @Override
    public List<Comment> getComments(User user) {
        String query = "FROM Comment c WHERE c.user.id = ?";
        return em.createQuery(query, Comment.class)
                .setParameter(1, user.getId()).getResultList();
    }

    @Override
    @Transactional
    public Comment save(Comment comment) {
        return em.merge(comment);
    }

    @Override
    @Transactional
    public void delete(Comment comment) {
        em.remove(comment);
    }
}
