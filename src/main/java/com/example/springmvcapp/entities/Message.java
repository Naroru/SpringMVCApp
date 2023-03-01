package com.example.springmvcapp.entities;

import jakarta.persistence.*;


/*

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
*/



@Entity
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
/*

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
*/

    private String text;

    private String tag;

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
        // this.author = author;
    }

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

/*    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }*/
}
