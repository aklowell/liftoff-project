package com.example.southside.models;


import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//TODO incorporate security: hashing, roles (TBD)
//TODO http://websystique.com/spring-security/spring-security-4-password-encoder-bcrypt-example-with-hibernate/ complicated
//TODO simpler - hashing only

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String username;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 15)
    private String password;

    private String role;

    private String language;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Completed> completed = new ArrayList<>();

    public User() {
    }


    public User(String username, String email, String password) {
        this.username = username;
        this.email=email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

