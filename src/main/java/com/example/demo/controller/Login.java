package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.tokenService.util.CreatToken;
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
    public static final String vsersion="1.0.0.0";
    private static final Logger logger = LoggerFactory.getLogger(Login.class);
    @Autowired
    private UserService userService;
    @Autowired
    private CreatToken creatToken;

    /**
     * 登陆界面
     */
    @RequestMapping("/login.html")
    public ModelAndView login() {
        return new ModelAndView("login.html");
    }

    @RequestMapping(value = "/loginIn", produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
    public String loginIn(String username, String password) {
        logger.info("33333333333333333333333333");
        String login = userService.login(username, password);
        User user = new User();
        if ("0".equals(login)) {
            logger.info("222222222222222222222222222222");
            user = userService.selectUserByUserName(username);
        }
        if ("0".equals(login)) {
            creatToken.creatToken(user);
            creatToken.save(creatToken.getToken(), user);
            logger.info("111111111111111111111111111111");
            return null;
        }
        return null;
    }

    /**z
     * 注册界面
     */
    @RequestMapping("/register.html")
    public ModelAndView register() {
        return new ModelAndView("register.html");
    }

    @RequestMapping(value = "/registerIn", produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
    public String registerIn(String userName, String passWord) {
        userService.register(userName, passWord);
        return "注册成功";
    }

    /**
     * 管理台界面
     */
    @RequestMapping("/manage.html")
    public ModelAndView management() {
        return new ModelAndView("manage.html");
    }
}
