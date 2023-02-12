package SpringMVCHibernate.dao;

import SpringMVCHibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
        System.out.println("Пользователь добавлен");
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        System.out.println("Лист пользователей получен");
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    @Transactional
    public User findUser(int id) {
        return entityManager.find(User.class, id);

    }
    @Override
    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }


}
