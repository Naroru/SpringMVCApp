package com.example.springmvcapp.repositories;

import com.example.springmvcapp.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;

import java.util.List;

public interface MessageRep extends CrudRepository<Message, Integer> {

    List<Message> findByTag(String tag);
}
