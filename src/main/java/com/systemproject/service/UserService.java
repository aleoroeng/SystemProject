package com.systemproject.service;

import com.systemproject.model.User;
import com.systemproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class UserService {
    private final int DATE_CUTOFF = 30;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User adduser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<User> usersRemoved = new ArrayList<>();
        LocalDate dateCutoff = LocalDate.now().minusDays(DATE_CUTOFF);

        for(User user: users){
            if(user.getDate().isBefore(dateCutoff)){
                usersRemoved.add(user);
            }
        }
        users.removeAll(usersRemoved);
        return users;
    }
}
