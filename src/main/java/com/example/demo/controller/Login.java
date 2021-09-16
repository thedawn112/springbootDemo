package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author ranran.mao
 * @date 2021/8/16 11:11
 */
@RestController
@RequestMapping("/ranmao")
public class Login {
    private static final Logger logger = LoggerFactory.getLogger(Login.class);
    @Autowired
    UserService userService;

    /**
     * 登陆界面
     */
    @RequestMapping("/login.html")
    public ModelAndView login() {
        return new ModelAndView("login.html");
    }

    @RequestMapping(value = "/loginIn", produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
    public String loginIn(String username, String password) {
        String login = userService.login(username, password);
        return login;
    }

    /**
     * 注册界面
     */
    @RequestMapping("/register.html")
    public ModelAndView register() {
        return new ModelAndView("register.html");
    }
}
