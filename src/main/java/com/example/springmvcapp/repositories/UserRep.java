
package com.example.springmvcapp.repositories;

import com.example.springmvcapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface UserRep extends JpaRepository<User,Long> {

     Optional<User> findByUsername(String username);
}

