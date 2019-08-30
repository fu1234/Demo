package com.coolwen.springjdbc.service;

import com.coolwen.springjdbc.model.Group;
import com.coolwen.springjdbc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Resource
    private GroupService groupService;

    @Test
    public void add() {
        User user = new User("Davis", "123", "野猪");
        Group g = groupService.load(2);
        user.setGroup(g);
        userService.add(user);
    }

    @Test
    public void delete() {
        userService.delete(9);
    }

    @Test
    public void update() {
        User u = new User();
        u = userService.load(1);
        u.setNickname("齐丹");
        u.setUsername("Zedan");
        userService.update(u);
    }

    @Test
    public void load() {
        System.out.println(userService.load(1));
    }

    @Test
    public void listAllUser() {
        System.out.println(userService.listAllUser());
    }

    @Test
    public void login() {
        System.out.println(userService.login("coolwen", "123"));
    }
}