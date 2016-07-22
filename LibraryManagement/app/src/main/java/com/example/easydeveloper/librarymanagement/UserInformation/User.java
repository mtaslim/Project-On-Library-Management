package com.example.easydeveloper.librarymanagement.UserInformation;

import java.util.ArrayList;

/**
 * Created by taslim on 7/20/2016.
 */
public class User {
    int userId;
    String userFullName,userName,userPassword;

    public User(int userId, String userFullName, String userName, String userPassword) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.userName = userName;
        this.userPassword = userPassword;
    }
    public User() {
    }

    public User(String userName,String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public ArrayList<User> GetAllUser(){
        ArrayList<User>user=new ArrayList<>();
        user.add(new User(1,"Mohammad Taslim","taslim","111"));
        user.add(new User(2,"Suman","suman","222"));
        user.add(new User(3,"Dalawer","dalawer","333"));

        return user;
    }

    public int Auth(String user, String password)
    {
        ArrayList<User>AllUser = this.GetAllUser();

        for(User u : AllUser)
        {
            if(u.getUserName().equalsIgnoreCase(user) && u.getUserPassword().equalsIgnoreCase(password))
            {
                return u.getUserId();
            }
        }
        return 0;
    }

    public String getUserInfo(int userId,String getData)
    {
        ArrayList<User>AllUser = this.GetAllUser();
        String returnData = "";

        for(User u : AllUser)
        {
            if(u.getUserId() == userId)
            {
                switch (getData){
                    case "userFullName":  returnData = u.getUserFullName(); break;
                    case "userName":  returnData = u.getUserName(); break;
                    case "userPassword":  returnData = u.getUserPassword(); break;
                }
                break;
            }
        }
        return returnData;
    }



}
