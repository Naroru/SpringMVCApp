package com.example.springmvcapp.controller;

import com.example.springmvcapp.entities.Roles;
import com.example.springmvcapp.entities.User;
import com.example.springmvcapp.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    UserRep userRep;

    @GetMapping
    public String users(Model model) {

        model.addAttribute("users", userRep.findAll());
        return "users";
    }

    // метод сработает при переходе с формы users.ftlh по ссылке td><a href="/user/${user.id}">edit</a></td>
    //user.id - это и будет user. Спринг автоматом преобразует id в пользователя. Мы связываем {user}" в URL и User через PathVariable
    @GetMapping("{user}")
    public String userEdit(@PathVariable User user, Model model)
    {
        model.addAttribute("user", user);
        model.addAttribute("roles", Roles.values());
        return "userEdit";
    }

    // @RequestParam Map<String,String> form возвращаем все реквизиты формы( но роли будут только помеченные)
    @PostMapping
    public String updateUser(@RequestParam("userId") User user,
                             @RequestParam String username,
                             @RequestParam Map<String,String> form)
    {

        user.setUsername(username);


        List<String> roles = Arrays.stream(Roles.values())
                .map(Enum::name).toList();

        //задаем пользователю новые роли. Для этого в списке всех ролей ищем элементы
        //возвращенные формы ( там будут возвращены все помеченные роли, а также другие реквизиты формы )
        user.getRoles().clear();
        for (String formElement : form.keySet()) {

            if (roles.contains(formElement))
                user.getRoles().add(Roles.valueOf(formElement));

        }
        userRep.save(user);
        return "redirect:/users";

    }
}
