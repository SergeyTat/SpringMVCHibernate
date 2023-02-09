package SpringMVCHibernate.dao;

import SpringMVCHibernate.model.User;

import java.util.List;

public interface UserDao {
    public void saveUser(User user);
    public List<User> listUsers();
}
