package com.example.southside.controllers;


import com.example.southside.models.Activity;
import com.example.southside.models.Skill;
import com.example.southside.models.data.ActivityDao;
import com.example.southside.models.data.SkillDao;
import com.example.southside.models.forms.AddSkillForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="skill")

public class SkillController {

    @Autowired
    private SkillDao skillDao;

    @Autowired
    private ActivityDao activityDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Skills");
        model.addAttribute("skills", skillDao.findAll());
        return "skill/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displaySkillAddForm(Model model) {
        model.addAttribute(new Skill());
        model.addAttribute("title", "Add a Skill");
        return "skill/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processSkillAddForm(Model model, @ModelAttribute @Valid Skill skill, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add a Skill");
            return "skill/add";
        }
        skillDao.save(skill);

        return "redirect:/skill";
    }

    @RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String displaySkills(@PathVariable int id, Model model) {
        Activity activity = activityDao.findOne(id);
        model.addAttribute(activity);

        return "skill/view";
    }

    @RequestMapping(value="add-to-activity/{id}", method=RequestMethod.GET)
    public String displaySkillForm (@PathVariable int id, Model model) {
        Activity activity = activityDao.findOne(id);

        AddSkillForm form = new AddSkillForm(activity, skillDao.findAll());
        model.addAttribute("title", "Add skills to " + activity.geteName());
        model.addAttribute("form", form);
        return "skill/add-to-activity";
    }

    @RequestMapping(value="add-to-activity", method=RequestMethod.POST)
    public String processSkillForm(Model model, @ModelAttribute AddSkillForm form) {
        Skill addSkill = skillDao.findOne(form.getSkillId());
        Activity updateActivity = activityDao.findOne(form.getActivityId());

        updateActivity.addItem(addSkill);

        activityDao.save(updateActivity);

        return "redirect:/activity";
    }
}