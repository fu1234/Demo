package com.coolwen.springjdbc.model;

/**
 * @author CoolWen
 * @version 2018-10-16 21:38
 */
public class Group {
    private int id;
    private String groupname;

    public Group(String groupname) {
        this.groupname = groupname;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupname='" + groupname + '\'' +
                '}';
    }
}
