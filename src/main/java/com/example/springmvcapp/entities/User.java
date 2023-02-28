
package com.example.springmvcapp.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import javax.persistence.*;

import java.util.Collection;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
    private boolean active;

    //Все поля Entity-класса, которые содержат много элементов и помечаются с помощью аннотации @ElementCollection содержатся в базе данных в специальной вспомогательной таблице.

    //если мы храним список чего-то в entity, значит в sql должна быть таблица, хранящая эти значения
    //например Город -> список жителей. Должна быть таблица Город_ID, Житель_ID. Чтобы вручную не создавать эту  таблицу
    //для хранения коллекций в entity испльзуется @ElementCollection. Параметры - целевой класс - то, что будем хранить в коллекции
    //fetch - есть в конспекте. Это загрузка. Ленивая или жадная. То есть сразу грузим коллекцию или ток при обращении к ней
    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)

    //вспомогательная таблица будет иметь имя, которое мы задаем как параметр name
    //а также здесь  в аннотации @JoinColumn(name = "user_id") мы указали имя колонки user_id, которая ссылается на id таблицы user. Это чтобы Hibernate знал, как их правильно объединять.
    @CollectionTable(name="user_message", joinColumns = @JoinColumn(name = "user_id"))

    //чтобы не создавать Entity для перечисления, мы указываем аннотацию @Enumerated
    //когда поле должно содержать перечисление
    //в качестве параметра мы можем указать какое значение будет храниться - строковое или гуид ссылки перечисления
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}

