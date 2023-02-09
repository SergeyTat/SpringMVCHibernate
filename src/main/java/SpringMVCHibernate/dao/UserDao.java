package SpringMVCHibernate.dao;

import SpringMVCHibernate.model.User;

import java.util.List;

public interface UserDao {
    public void saveUser(String name, String lastName);
    public List<User> listUsers();
}
