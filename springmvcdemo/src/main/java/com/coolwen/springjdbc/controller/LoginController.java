package com.coolwen.springjdbc.controller;

import com.coolwen.springjdbc.model.User;
import com.coolwen.springjdbc.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author CoolWen
 * @version 2018-10-04 22:00
 */
@Controller
@SessionAttributes("loginUser")
public class LoginController {

    private static Logger LOGGER = LogManager.getLogger(LoginController.class);
    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(String username, String password, Model model) {
        User u = userService.login(username, password);
        LOGGER.debug(u);
        model.addAttribute("loginUser", u);
        return "redirect:/user/listall";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        model.asMap().remove("loginUser");
        session.invalidate();
        return "redirect:/login";
    }
}
