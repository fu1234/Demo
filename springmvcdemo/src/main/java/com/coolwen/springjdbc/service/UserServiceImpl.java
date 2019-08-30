package com.coolwen.springjdbc.service;

import com.coolwen.springjdbc.dao.IGroupDao;
import com.coolwen.springjdbc.dao.IUserDao;
import com.coolwen.springjdbc.exception.UserException;
import com.coolwen.springjdbc.model.Group;
import com.coolwen.springjdbc.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author CoolWen
 * @version 2018-10-30 21:11
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private IUserDao userDao;

    @Resource
    private IGroupDao groupDao;

    @Override
    public void add(User user) {
        User u = userDao.loadUserByUserName(user.getUsername());
        if (u != null) throw new UserException("添加的用户名已经存在");
        Group g = new Group();
        g = groupDao.load(user.getGroup().getId());
        if (g == null)
            throw new UserException("添加的用户组不存在！");
//        user.setGid(g.getId());
        userDao.add(user, g.getId());
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User load(int id) {
        return userDao.load(id);
    }

    @Override
    public List<User> listAllUser() {
        return userDao.listAll();
    }

    @Override
    public User login(String username, String password) {
        User u = userDao.loadUserByUserName(username);
        if (u == null) throw new UserException("用户名或者密码错误");
        if (!u.getPassword().equals(password)) throw new UserException("用户名或者密码错误");
        return u;
    }
}
