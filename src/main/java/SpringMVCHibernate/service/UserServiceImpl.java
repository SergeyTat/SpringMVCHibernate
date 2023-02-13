package SpringMVCHibernate.service;

import SpringMVCHibernate.dao.UserDao;
import SpringMVCHibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User findUser(int id) {
        return userDao.findUser(id);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }
}
