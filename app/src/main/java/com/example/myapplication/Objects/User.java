package com.example.myapplication.Objects;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String surname;
    private String login;
    private int age;
    private String password;

    public User(String name, String surname, String login, int age, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.age = age;
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
