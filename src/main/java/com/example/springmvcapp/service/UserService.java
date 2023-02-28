package com.example.springmvcapp.service;

import com.example.springmvcapp.entities.User;
import com.example.springmvcapp.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRep userRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =  userRep.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User was not find"));
        return new SecurityUser(user);
    }
}
