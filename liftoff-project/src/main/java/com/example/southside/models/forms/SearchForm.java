package com.example.southside.models.forms;

import com.example.southside.models.Activity;


import javax.validation.constraints.NotNull;

public class SearchForm {

    private Activity activity;

    public Activity getActivity() { return activity; }

    public void setActivity(Activity activity) {this.activity = activity;}


    private int activityId;

    public int getActivityId() { return activityId; }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }



    public SearchForm(Activity activity, String subject, String ages, String where) {
        this.activity=activity;
        this.subject=subject;
        this.ages=ages;
        this.where=where;
    }



    //ADAPTED FROM TECHJOBS
    private Iterable<Activity> activities;
    public Iterable<Activity> getActivities() {return activities;}
    public void setActivities(Iterable<Activity>activities) {this.activities = activities;}

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String subject;

    private String ages;

    private String where;

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public SearchForm() {}



}
