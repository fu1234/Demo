package com.coolwen.springjdbc.service;

import com.coolwen.springjdbc.model.Group;

import java.util.List;

/**
 * @author CoolWen
 * @version 2018-10-24 10:18
 */

public interface GroupService {
    public void add(Group group);

    public void delete(int gid);

    public void update(Group group);

    public Group load(int gid);


    public List<Group> listAll();
}
