package com.coolwen.springjdbc.controller;

import com.coolwen.springjdbc.model.User;
import com.coolwen.springjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author CoolWen
 * @version 2018-10-30 21:57
 */
@RestController//return Json data
public class HelloController {

    @Autowired
    private UserService userService;

    //RequestMapping中的value 表示访问的路径
    @RequestMapping(value = {"/", "/hello"}, method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping("/listJson")
    public List<User> listJson() {
        return userService.listAllUser();
    }
}
