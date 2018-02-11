package com.example.southside.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Skill {
    @Id
    @GeneratedValue
    private int id;

    private String engName;

    private String espName;

    public List<Activity> getActivities() {
        return activities;
    }

    @ManyToMany(mappedBy = "skills")
    private List<Activity> activities;

    public Skill(String engName, String espName) {
        this.engName = engName;
        this.espName = espName;
    }

    public Skill() {}

    public int getId() {
        return id;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getEspName() {
        return espName;
    }

    public void setEspName(String espName) {
        this.espName = espName;
    }
}
