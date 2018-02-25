package com.example.southside.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Time {

    @Id
    @GeneratedValue
    private int id;

    private int minutes;

    @ManyToMany(mappedBy="times")
    private List<Activity> activities;

    @ManyToMany(mappedBy="times")
    private List<User> users;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getId() {
        return id;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Time(int minutes) {
        this.minutes=minutes;
    }

    public Time () {}
}
