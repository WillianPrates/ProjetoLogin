package com.feldmann.projetologin.repository;

import android.util.Log;

import com.feldmann.projetologin.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDataBase {
    private static final String tagLog = "UserDataBase";
    //
    private static List<User> users;
    private static UserDataBase instance = null;
    //
    private UserDataBase(){
        super();
        if (users == null) {
            users = new ArrayList<>();
            users.add(new User(1, "fabio1", "fbo1", "senha1"));
            users.add(new User(2, "fabio2", "fbo2", "senha2"));
            users.add(new User(3, "fabio3", "fbo3", "senha3"));
            users.add(new User(4, "fabio4", "fbo4", "senha4"));
            Log.d(tagLog, "usuarios criados");
        }
    }
    //
    public static List<User> getUsers(){ return users; }
    //
    public static UserDataBase getInstance() {
        if (instance == null) {
        instance = new UserDataBase();
        }
        return instance;
    }
    //
    public User getUserByLogin(String login){
        Log.d(tagLog, tagLog+"/getUserByLogin");
        User ret = null;
        for(User u : users){
            if (u.getLogin().equals(login)){
                ret = u;
            }//fim if
        }//fim for
        return ret;
    }//fim metodo
}//fim classe
