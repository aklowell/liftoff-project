package com.example.southside.controllers;


import com.example.southside.models.*;
import com.example.southside.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("activity")
@SessionAttributes("user")
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private SkillDao skillDao;

    @Autowired
    private CompletedDao completedDao;

    @Autowired
    private UserDao userDao;

    //Request path: /index - for teachers & admins only
    //from here they add, edit and delete

    //TODO ADD EDIT FUNCTION


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

    //TODO Add a way to check if activity has already been entered, confirm user wants to enter it again.

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddActivityForm(@ModelAttribute @Valid Activity newActivity, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Activity");

            return "activity/add";
        }

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
    public String processCompletedForm(@PathVariable int id, Model model, int minutes, String comments, Date dateCompleted) {
        Activity completedActivity=activityDao.findOne(id);

/* TODO save the time to the user also- need to do full login process first */
/* TODO get the date to populate in the database!! */
        Completed newCompleted = new Completed();
        newCompleted.setMinutes(minutes);
        newCompleted.setComments(comments);
        newCompleted.setDateCompleted(dateCompleted);

        newCompleted.setActivity(completedActivity);

        completedDao.save(newCompleted);


        return "redirect:/search";
        }
    }


