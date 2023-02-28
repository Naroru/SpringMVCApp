package com.example.springmvcapp.controller;

import com.example.springmvcapp.entities.Message;
import com.example.springmvcapp.entities.User;
import com.example.springmvcapp.repositories.MessageRep;
import com.example.springmvcapp.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@org.springframework.stereotype.Controller
public class MainController {

    @Autowired
    private MessageRep messageRep;

    @Autowired
    private UserRep userRep;


    @GetMapping("/")
    public String greeting() {

        System.out.println(userRep.findByUsername("us").isPresent());

        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {

        Iterable<Message> messages  = messageRep.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String addMessage(@RequestParam String text, @RequestParam String tag, Map<String, Object> model )
    {
        Message message = new Message(text,tag);
        messageRep.save(message);


        Iterable<Message> messages  = messageRep.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/filter")
    public String addMessage(@RequestParam String filter, Map<String, Object> model )
    {

        Iterable<Message> messages;

        if(filter == null || filter.isEmpty())
            messages = messageRep.findAll();
        else
            messages = messageRep.findByTag(filter);

        model.put("messages", messages);
        return "main";
    }
}
