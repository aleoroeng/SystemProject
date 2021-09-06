package com.systemproject.service;

import com.systemproject.model.Admin;
import com.systemproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Admin> admins = adminRepository.findByUsername(username);
        if(admins.isEmpty()){
            throw new UsernameNotFoundException("Admin with username " + username + " was not found");
        }
        return admins.get(0);
    }
}
