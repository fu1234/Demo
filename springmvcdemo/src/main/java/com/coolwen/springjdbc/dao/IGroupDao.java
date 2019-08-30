package com.coolwen.springjdbc.dao;

import com.coolwen.springjdbc.model.Group;

import java.util.List;

/**
 * @author CoolWen
 * @version 2018-10-16 21:46
 */
public interface IGroupDao {
    public void add(Group group);

    public void delete(int id);

    public void update(Group group);

    public Group load(int id);

    public List<Group> list(String sql,Object[] args);
}
