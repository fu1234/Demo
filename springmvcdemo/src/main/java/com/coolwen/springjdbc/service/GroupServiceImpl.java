package com.coolwen.springjdbc.service;

import com.coolwen.springjdbc.dao.IGroupDao;
import com.coolwen.springjdbc.model.Group;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author CoolWen
 * @version 2018-10-24 10:19
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService {

    @Resource
    private IGroupDao groupDao;

    @Override
    public void add(Group group) {
        groupDao.add(group);

    }

    @Override
    public void delete(int gid) {
        groupDao.delete(gid);
    }

    @Override
    public void update(Group group) {
        groupDao.update(group);
    }

    @Override
    public Group load(int gid) {
        return groupDao.load(gid);
    }

    @Override
    public List<Group> listAll() {
        String sql = "select * from t_group";
        return groupDao.list(sql, null);
    }
}
