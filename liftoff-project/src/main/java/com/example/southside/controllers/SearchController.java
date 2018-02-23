package com.example.southside.controllers;


import com.example.southside.models.Activity;
import com.example.southside.models.User;
import com.example.southside.models.data.ActivityDao;
import com.example.southside.models.data.SkillDao;

import com.example.southside.models.forms.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
@RequestMapping("search")
public class SearchController {

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    SkillDao skillDao;

    private Activity activity = Activity.getInstance();


    @RequestMapping(value = "")

    public String index(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("title", "Search Activities");

        model.addAttribute(new SearchForm());
        if (user.getLanguage().equalsIgnoreCase("es")) {

            return "search/search_es";
        } else {
            return "search/search";
        }
    }


    @RequestMapping(value = "results")
    public String search(@ModelAttribute("user") User user, Model model, @ModelAttribute SearchForm searchForm) {
        // ArrayList<Activity> activities;
//TODO Separate the "All" Case to a separate page or a menu tab

            model.addAttribute("bysubjects", activityDao.findByESubject(searchForm.getSubject()));
            model.addAttribute("ages", activityDao.findByEAges(searchForm.getAges()));
            model.addAttribute("wheres", activityDao.findByEWhere(searchForm.getWhere()));


            if (user.getLanguage().equalsIgnoreCase("es")) {

            return "search/results_es";
    }  else {
            return "search/results";
            }
            }
//TODO CLEAR THE PREVIOUS SEARCH BEFORE THEY DO A NEW ONE
}
  //      return "search/index";
  //  }

 /*  TOOK THIS OUT TO TRY NEW STUFF 2.3.18

    @RequestMapping(value = "results")

    public String processSearchForm(Model model, String search1) {
        List<Activity> all = new ArrayList<>();
        Activity one = new Activity();
        model.addAttribute("activities", activityDao.findAll());
   /*     for (Activity one : all) {
            if (one.geteSubject().equalsIgnoreCase("Literacy")) {
                activities.add(one);
                model.addAttribute(activities);
            }

        }
        return "search/results";
    }

    /*
    USE THIS TO TAKE IN SEARCHFORM "subject" and get list
     @RequestMapping(value = "results")
    public String search(Model model,
                         @ModelAttribute SearchForm searchForm) {

        ArrayList<Job> jobs;

        if (searchForm.getSearchField().equals(JobFieldType.ALL)) {
            jobs = jobData.findByValue(searchForm.getKeyword());
        } else {
            jobs = jobData.findByColumnAndValue(searchForm.getSearchField(), searchForm.getKeyword());
        }

        model.addAttribute("jobs", jobs);

        return "search";
    }
     */


