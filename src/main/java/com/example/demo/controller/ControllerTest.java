package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ranmao")
public class ControllerTest {
    @Autowired
    private UserService userService;

    @RequestMapping("/getuser/{id}")
    public String getUser(@PathVariable int id) {
        return userService.selectUser(id).toString();
    }
}
