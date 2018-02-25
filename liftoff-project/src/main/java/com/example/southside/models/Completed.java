package com.example.southside.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

@Entity
public class Completed {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private User user;

    private int minutes;

    private String comments;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCompleted;

    public Completed(int minutes, String comments, Date dateCompleted) {
        this.minutes = minutes;
        this.comments = comments;
        this.dateCompleted = dateCompleted;
    }

    public Completed() {}

    public int getId() {
        return id;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }


}
