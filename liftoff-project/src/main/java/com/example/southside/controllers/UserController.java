package com.example.southside.controllers;


import com.example.southside.models.User;
import com.example.southside.models.data.UserDao;

import com.example.southside.models.forms.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;

@Controller
@RequestMapping(value="user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute(new User());
        return "user/add";
        }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        if (errors.hasErrors()) {
            model.addAttribute(user);
            return "user/add";
        }

        if (!(user.getPassword().equals(verify)) || ((verify.isEmpty()) || (user.getPassword().isEmpty()))) {
            model.addAttribute("error", "Password and verify must be filled in and match.");
            return "user/add";
        }

        else {
            model.addAttribute("username", user.getUsername());
            userDao.save(user);
            return "user/add";
        }
    }

    //TODO set this up to check for user in database and give access to correct locations

    @RequestMapping(value="login", method=RequestMethod.GET)
    public String login (Model model, LoginForm loginForm) {
        model.addAttribute(loginForm);
        return "user/login";

    }

    @RequestMapping(value="login", method=RequestMethod.POST)
    public String login(Model model, LoginForm loginForm, String language) {
        model.addAttribute(loginForm);
        if (language.equalsIgnoreCase("en")) {
            return "user/test";
        }

        return "user/login";
    }

}
