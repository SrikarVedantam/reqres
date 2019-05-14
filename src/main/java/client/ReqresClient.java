package client;

import entities.User;
import entities.UserWrapper;

import java.util.List;

public interface ReqresClient {
    List<User> getAllUsers();
    User getUser(int id);
    User PostUser(User user);
}
