package com.coolwen.springjdbc.dao;

import com.coolwen.springjdbc.model.User;

import java.util.List;

/**
 * @author CoolWen
 * @version 2018-10-16 22:23
 */
public interface IUserDao {
    public void add(User user, int gid);

    public void delete(int id);

    public void update(User user);

    public User load(int id);

    public List<User> list(String sql, Object[] args);

    List<User> listAll();

    User loadUserByUserName(String username);
}
