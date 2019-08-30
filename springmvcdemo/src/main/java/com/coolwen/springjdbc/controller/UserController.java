package com.coolwen.springjdbc.controller;

import com.coolwen.springjdbc.model.Group;
import com.coolwen.springjdbc.model.User;
import com.coolwen.springjdbc.service.GroupService;
import com.coolwen.springjdbc.service.UserService;

import com.sun.prism.GraphicsResource;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;
import java.util.List;


/**
 * @author CoolWen
 * @version 2018-11-07 9:11
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger LOGGER = LogManager.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;

    //表示返回json数据
    @RequestMapping(value = "/listjson")// /user/list
    @ResponseBody
    public List<User> list() {
        List<User> users = userService.listAllUser();
        LOGGER.debug(users);
        return users;
    }

    @RequestMapping(value = "/listall")// /user/list
    public String listAll(Model model) {
        List<User> users = userService.listAllUser();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/user/listall";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute(new User());
        List<Group> groups = groupService.listAll();
        model.addAttribute("groups", groups);
        return "user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user) {
        System.out.println(user);
        Group group = new Group();
        group.setId(user.getGroup().getId());
        user.setGroup(group);
        userService.add(user);
        return "redirect:/user/listall";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        model.addAttribute(userService.load(id));

        return "user/update";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable int id, User user, Model model) {
        User tu = userService.load(id);
        tu.setUsername(user.getUsername());
        tu.setPassword(user.getPassword());
        tu.setNickname(user.getNickname());
        Group group = new Group();
        group.setId(3);
        tu.setGroup(group);
        userService.update(tu);
        return "redirect:/user/listall";
    }

    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String show(@PathVariable int id, Model model) {
        User u = userService.load(id);
        model.addAttribute("user", u);
        return "user/show";
    }
}
