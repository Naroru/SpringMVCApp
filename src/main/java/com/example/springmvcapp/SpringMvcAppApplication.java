package com.example.springmvcapp;

import com.example.springmvcapp.entities.User;
import com.example.springmvcapp.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcAppApplication {



    public static void main(String[] args) {



        SpringApplication.run(SpringMvcAppApplication.class, args);
    }

}
