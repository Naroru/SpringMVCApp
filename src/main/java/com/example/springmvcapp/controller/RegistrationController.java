package com.example.springmvcapp.controller;

import com.example.springmvcapp.entities.Roles;

import com.example.springmvcapp.entities.User;
import com.example.springmvcapp.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class RegistrationController {


    @Autowired
    UserRep userRep;


    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        boolean userExists = userRep.findByUsername(user.getUsername()).isPresent();
        if (!userExists) {

            Set<Roles> roles = new HashSet<>();
            roles.add(Roles.USER);

            user.setActive(true);
            user.setRoles(roles);
            userRep.save(user);

        } else {
            model.put("message", "user exist!");
            return "registration";
        }

        return "redirect:/login";
    }


}
