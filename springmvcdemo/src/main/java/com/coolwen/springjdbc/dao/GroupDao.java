package com.coolwen.springjdbc.dao;

import com.coolwen.springjdbc.model.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author CoolWen
 * @version 2018-10-16 21:48
 */
@Repository("groupDao")
public class GroupDao implements IGroupDao {
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final Group group) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String INSERT_SQL = "insert into t_group (group_name) values ( ?)";
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                        ps.setString(1, group.getGroupname());
                        return ps;
                    }
                },
                keyHolder);
        group.setId(keyHolder.getKey().intValue());
    }

    public void delete(int id) {
        this.jdbcTemplate.update(
                "delete from t_group where id = ?",
                id);
    }

    public void update(Group group) {
        this.jdbcTemplate.update(
                "update t_group set group_name = ? where id = ?",
                group.getGroupname(), group.getId());


    }

    public Group load(int id) {
        String sql = "select * from t_group where id = ?";
        Group group = this.jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new RowMapper<Group>() {
                    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Group group = new Group();
                        group.setGroupname(rs.getString("group_name"));
                        group.setId(rs.getInt("id"));
                        return group;
                    }
                });
        return group;

    }

    @Override
    public List<Group> list(String sql, Object[] args) {

        return this.jdbcTemplate.query(sql, args, new RowMapper<Group>() {
            public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
                Group group = new Group();
                group.setGroupname(rs.getString("group_name"));
                group.setId(rs.getInt("id"));
                return group;
            }
        });
    }
}
