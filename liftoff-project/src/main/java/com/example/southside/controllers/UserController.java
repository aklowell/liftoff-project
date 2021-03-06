package com.example.southside.controllers;


import com.example.southside.models.User;
import com.example.southside.models.data.UserDao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value="user")
@SessionAttributes("user")
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

    @RequestMapping(value = "login", method=RequestMethod.GET)
    public String login(Model model){

        return "user/login";
    }



/*    @RequestMapping(value="login", method=RequestMethod.GET)
    public String login (Model model, LoginForm loginForm) {
        model.addAttribute(loginForm);
        return "user/login";

    }
*/

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }



    @RequestMapping(value="home", method=RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, Model model) {
           // model.addAttribute("user", user.getUsername());
            if (user.getRole().equalsIgnoreCase("staff")) {
                return "user/staff";
            }
                if (user.getRole().equalsIgnoreCase("family")
                    && (user.getLanguage().equalsIgnoreCase("es"))) {
                    return "user/home_es";
                }

                if (user.getRole().equalsIgnoreCase("family")
                        && (user.getLanguage().equalsIgnoreCase("en"))) {
                    return "user/home_en";
        }
             else model.addAttribute("error", "No such user exists - see SouthSide to register.");
                return "user/login";
    }

    /*@Controller
    public class LogoutController {   */

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "user/logout";
        }

    }


