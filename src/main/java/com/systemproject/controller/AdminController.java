package com.systemproject.controller;

import com.systemproject.model.Admin;
import com.systemproject.model.User;
import com.systemproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/current")
    public String getCurrentAdmin(Principal principal){
        return principal.getName();
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> sortedListOfAllUsers = userService.getAllUsers();
        Collections.sort(sortedListOfAllUsers);

        return sortedListOfAllUsers;
    }

    @GetMapping("/logout")
    public void logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.adduser(user);
    }
}
