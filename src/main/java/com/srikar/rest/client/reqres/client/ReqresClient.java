package com.srikar.rest.client.reqres.client;

import com.srikar.rest.client.reqres.entities.*;
import java.util.List;

public interface ReqresClient {
    List<User> getAllUsers();
    User getUser(int id);
    User PostUser(User user);
}
