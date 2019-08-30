package com.coolwen.springjdbc.dao;

import com.coolwen.springjdbc.model.Group;
import com.coolwen.springjdbc.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author CoolWen
 * @version 2018-10-24 9:08
 */
@Repository("userDao")
public class UserDao implements IUserDao {

    private JdbcTemplate jdbcTemplate;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(User user, int gid) {
        jdbcTemplate.update("INSERT INTO t_user  (user_name,password,nick_name,gid) VALUE (?,?,?,?)",
                user.getUsername(), user.getPassword(), user.getNickname(), gid);

    }

    public void delete(int id) {
        jdbcTemplate.update(
                "delete from t_user where id = ?", id);
    }

    public void update(User user) {
        String sql = "update t_user set user_name=? ,password=? , nick_name=? ,gid=? where id=?";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getNickname(), user.getGroup().getId(), user.getId());
    }

    public User load(int id) {
        String sql = "SELECT\n" +
                "t1.id,\n" +
                "t1.user_name,\n" +
                "t1.`password`,\n" +
                "t1.nick_name,\n" +
                "t1.gid,\n" +
                "t2.group_name\n" +
                "FROM\n" +
                "t_user AS t1\n" +
                "LEFT JOIN t_group AS t2 ON t1.gid = t2.id\n" +
                "WHERE\n" +
                "t1.id=?\n";
        User user = this.jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
        return user;
    }

    public List<User> list(String sql, Object[] args) {

        return this.jdbcTemplate.query(sql, args, new UserMapper());
    }

    @Override
    public List<User> listAll() {
        String sql = "SELECT t1.id uid,t1.*, t2.* FROM t_user t1 LEFT JOIN t_group t2 ON (t1.gid = t2.id) ;";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public User loadUserByUserName(String username) {
        String sql = "SELECT\n" +
                "\tt1.id uid,\n" +
                "\tt1.*, t2.*\n" +
                "FROM\n" +
                "\tt_user t1\n" +
                "LEFT JOIN t_group t2 ON (t1.gid = t2.id)\n" +
                "where user_name=?";
        User user = new User();
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            return user = null;
        }
        return user;
    }

    private class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("user_name"));
            user.setNickname(rs.getString("nick_name"));
            user.setPassword(rs.getString("password"));
            Group g = new Group();
            g.setId(rs.getInt("gid"));
            g.setGroupname(rs.getString("group_name"));
            user.setGroup(g);
            return user;
        }
    }

}
