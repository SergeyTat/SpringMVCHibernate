package SpringMVCHibernate.dao;

import SpringMVCHibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void saveUser(String name, String lastName) {
        User user = new User(name, lastName);
        entityManager.persist(user);
        System.out.println("Пользователь добавле");


    }


}
