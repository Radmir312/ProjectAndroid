package com.example.myapplication.Objects;

import java.util.ArrayList;
import java.util.Optional;

public class UserDatabase {
    private static ArrayList<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }
    public User findUser(String login){
        Optional<User> user = users.stream().filter(u -> u.getLogin().equals(login)).findFirst();
        if(user.isPresent()){
            return user.get();
        }
        else{
            return null;
        }
    }
}
