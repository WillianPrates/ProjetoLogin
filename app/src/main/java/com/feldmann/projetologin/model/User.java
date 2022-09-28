package com.feldmann.projetologin.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int id;
    private String nome;
    private String login;
    private String senha;
    //
    public User(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    //
    protected User(Parcel in){
        id = in.readInt();
        nome = in.readString();
        login = in.readString();
        senha = in.readString();
    }
    //
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) { return new User(source); }
        //
        @Override
        public User[] newArray(int size) { return new User[size]; }
    };
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

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeString(login);
        dest.writeString(senha);
    }
    //
}
