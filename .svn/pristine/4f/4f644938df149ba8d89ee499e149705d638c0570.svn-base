package springmusic.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmusic.model.User;
import springmusic.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        em.remove(user);
    }

    @Override
    public List<User> getUsers() {
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    @Transactional
    public User save(User user) {
        return em.merge(user);
    }

    @Override
    public List<User> searchSearch(String searchTerm) {
        String query = "FROM User u WHERE UPPER(u.email) LIKE  ?1 "
                + "OR UPPER(u.firstName) like ?1 "
                + "OR UPPER(u.lastName) like ?1";
        return em.createQuery(query, User.class)
                .setParameter(1, "%" + searchTerm.toUpperCase() + "%")
                .getResultList();
    }

    @Override
    public boolean isEmailUnique(String email) {
        String query = "From User u WHERE UPPER(u.email) = :email";
        return em.createQuery(query, User.class)
                .setParameter("email", email.toUpperCase()).getResultList()
                .isEmpty();
    }
}
