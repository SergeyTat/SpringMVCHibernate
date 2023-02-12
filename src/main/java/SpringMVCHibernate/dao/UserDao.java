package SpringMVCHibernate.dao;

import SpringMVCHibernate.model.User;

import java.util.List;

public interface UserDao {
    public void saveUser(User user);
    public List<User> listUsers();
    public User findUser(int id);
    public User updateUser(User user);
}
