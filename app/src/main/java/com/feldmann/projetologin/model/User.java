package com.feldmann.projetologin.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String nome;
    private String login;
    private String senha;
    //
    private static List<User> users;
    //
    public User(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    //
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    //
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    //
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    //
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    //
    public static List<User> getUsers(){
        if (users == null) {
            users = new ArrayList<>();
            users.add(new User(1, "fabio1", "fbo1", "senha1"));
            users.add(new User(2, "fabio2", "fbo2", "senha2"));
            users.add(new User(3, "fabio3", "fbo3", "senha3"));
            users.add(new User(4, "fabio4", "fbo4", "senha4"));
            Log.d("User", "usuarios criados");
        }
        return users;
    }
    //
}
