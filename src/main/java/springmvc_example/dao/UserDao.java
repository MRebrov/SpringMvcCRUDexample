package springmvc_example.dao;

import springmvc_example.model.User;

import java.util.List;

public interface UserDao {

    public List<User> listAllUsers();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    public User findUserById(int id);
}
