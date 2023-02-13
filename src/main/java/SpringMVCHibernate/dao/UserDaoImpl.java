package SpringMVCHibernate.dao;

import SpringMVCHibernate.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
        System.out.println("Пользователь добавлен");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        System.out.println("Лист пользователей получен");
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User findUser(int id) {
        return entityManager.find(User.class, id);

    }

    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void removeUser(int id) {
        entityManager.createQuery("delete from User user where user.id=:id")
                .setParameter("id", id)
                .executeUpdate();


    }


}
