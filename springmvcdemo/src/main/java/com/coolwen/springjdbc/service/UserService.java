package com.coolwen.springjdbc.service;


import com.coolwen.springjdbc.model.User;

import java.util.List;

/**
 * @author CoolWen
 * @version 2018-10-02 19:22
 */
public interface UserService {
    public void add(User user);

    public void delete(int id);

    public void update(User user);

    public User load(int id);

    public List<User> listAllUser();


    public User login(String username, String password);
}
