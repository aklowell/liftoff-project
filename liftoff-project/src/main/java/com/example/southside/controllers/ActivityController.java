package com.example.southside.controllers;


import com.example.southside.models.Activity;
import com.example.southside.models.Skill;
import com.example.southside.models.Time;
import com.example.southside.models.User;
import com.example.southside.models.data.ActivityDao;
import com.example.southside.models.data.SkillDao;
import com.example.southside.models.data.TimeDao;
import com.example.southside.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("activity")
@SessionAttributes("user")
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private SkillDao skillDao;

    @Autowired
    private TimeDao timeDao;

    @Autowired
    private UserDao userDao;

    //Request path: /index - for teachers & admins only
    //from here they add, edit and delete
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("activities", activityDao.findAll());
        model.addAttribute("title", "Activity List");
        return "activity/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddActivityForm(Model model) {
        model.addAttribute("title", "Add Activity");
        model.addAttribute(new Activity());

        return "activity/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddActivityForm(@ModelAttribute @Valid Activity newActivity, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Activity");

            return "activity/add";
        }

        //TODO Add a way to check if activity has already been entered, confirm user wants to enter it again.
        activityDao.save(newActivity);

        return "redirect:/activity";
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String displayDetailsForm(@PathVariable int id, Model model) {
        Activity displayActivity = activityDao.findOne(id);
        model.addAttribute("name", displayActivity.geteName());
     //   model.addAttribute("activityId", activityDao.findOne(id));
        model.addAttribute(displayActivity);


            return "activity/detail";

    }

    @RequestMapping(value = "detalles/{id}", method = RequestMethod.GET)
    public String displayDetailsFormSpanish(@PathVariable int id, Model model) {
        Activity displayActivity = activityDao.findOne(id);
        model.addAttribute("name", displayActivity.geteName());
        //model.addAttribute("activityId", activityDao.findOne(id));
        model.addAttribute(displayActivity);


        return "activity/detalles";

    }



    @RequestMapping(value="completed/{id}", method=RequestMethod.GET)
    public String displayCompletedForm(@PathVariable int id, Model model) {
        Activity completeActivity = activityDao.findOne(id);

        model.addAttribute("name", completeActivity.geteName());

        return "activity/completed";
    }

    @RequestMapping(value="completed/{id}", method=RequestMethod.POST)
    public String processCompletedForm(@PathVariable int id, Model model, int minutes) {
        Activity updateActivity=activityDao.findOne(id);

/* TODO save the time to the user also- need to do full login process first */

        Time newtime = new Time();
        newtime.setMinutes(minutes);
        timeDao.save(newtime);

        updateActivity.addTime(newtime);
        activityDao.save(updateActivity);


        return "redirect:/search";
        }
    }


