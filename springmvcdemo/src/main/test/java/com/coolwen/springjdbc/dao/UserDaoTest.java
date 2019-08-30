package com.coolwen.springjdbc.dao;

import com.coolwen.springjdbc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class UserDaoTest {
    @Autowired
    private IUserDao userDao;

    @Test
    public void add() {
        User u= new User("w","123","ww");
        userDao.add(u,2);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void load() {
        userDao.load(1);
    }

    @Test
    public void list() {
    }

    @Test
    public void listAll() {
    }

    @Test
    public void login() {
    }
}