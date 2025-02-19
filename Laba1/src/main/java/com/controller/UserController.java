package main.java.com.controller;

import main.java.com.model.User;
import java.util.Random;

public class UserController {

    public static User createUser(String username, String password, String email) {
        Random rand = new Random();
        int walletnumber=((rand.nextInt(100000000)+1)/2*5)%15;
        int balance=100000;
        User user=new User(username,password,email,walletnumber,balance);
        return user;
    }



}
