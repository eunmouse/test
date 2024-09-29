package shop.mtcoding.codingtest.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shop.mtcoding.codingtest.core.error.ex.Exception404;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public User findById(int id) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
        query.setParameter("id", id);

        User user = (User) query.getSingleResult();
        return user;
    }

    public List<User> findAll() {
        Query query = em.createQuery("SELECT u.id FROM User u order by u.id desc", User.class);
        List<User> userList = query.getResultList();
        return userList;
    }

    public void save(User user) {
        em.persist(user);
    }
}
