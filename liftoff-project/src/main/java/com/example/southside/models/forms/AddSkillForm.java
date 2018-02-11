package com.example.southside.models.forms;

import com.example.southside.models.Activity;
import com.example.southside.models.Skill;

import javax.validation.constraints.NotNull;

public class AddSkillForm {

    private Activity activity;

    private Iterable<Skill> skills;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Iterable<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Iterable<Skill> skills) {
        this.skills = skills;
    }

    @NotNull
    private int activityId;

    @NotNull
    private int skillId;

    public int getActivityId() {
        return activityId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public AddSkillForm(Activity activity, Iterable<Skill> skills) {
        this.activity=activity;
        this.skills=skills;
    }

    public AddSkillForm() {}
}
