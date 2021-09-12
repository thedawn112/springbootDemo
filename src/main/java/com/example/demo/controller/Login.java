package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping("/login.html")
    public ModelAndView login() {
        return new ModelAndView("login.html");
    }

    @RequestMapping(value = "/loginIn", produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
    public String loginIn(String username, String password) {
        logger.info(username + "...." + password);
        return null;
    }

    @RequestMapping("/register.html")
    public ModelAndView register() {
        return new ModelAndView("register.html");
    }
}
