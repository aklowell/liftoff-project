package com.example.southside.controllers;


import com.example.southside.models.Time;
import com.example.southside.models.data.ActivityDao;
import com.example.southside.models.data.TimeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="time")
@SessionAttributes("user")

public class TimeController {

    @Autowired
    private TimeDao timeDao;

    @Autowired
    private ActivityDao activityDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayTimeAddForm(Model model) {
        model.addAttribute(new Time());
        model.addAttribute("title", "Add a Time");
        return "time/add";
    }




    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processSkillAddForm(Model model, @ModelAttribute @Valid Time time, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add a Time");

            return "time/add";
        }
        timeDao.save(time);

        return "redirect:/time/add";
    }
}
