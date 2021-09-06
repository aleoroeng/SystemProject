package com.systemproject.controller;

import com.systemproject.model.User;
import com.systemproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/user/apply")
    public User apply(@RequestBody User user){
        System.out.println(user);
        return userService.adduser(user);
    }
}
