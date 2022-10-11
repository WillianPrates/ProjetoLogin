package com.feldmann.projetologin.presenter;

public class DataBasePresenter implements PresenterContract.presenterDB{
    //
    private String sqlStatement;
    //
    private PresenterContract.view view;
    public DataBasePresenter(PresenterContract.view view) { this.view = view; }
    //
    @Override
    public String criarTabelaPosts() {
        sqlStatement = "CREATE TABLE IF NOT EXISTS posts (" +
                "userId INTEGER, " +
                "_id INTEGER PRIMARY KEY, " +
                "titulo TEXT, " +
                "corpo TEXT " +
                ");";
        return sqlStatement;
    }

    @Override
    public String criarTabelaComments() {
        sqlStatement = "CREATE TABLE IF NOT EXISTS comments (" +
                "postId INTEGER, " +
                "_id INTEGER PRIMARY KEY, " +
                "nome TEXT, " +
                "email TEXT, " +
                "corpo TEXT " +
                ");";
        return sqlStatement;
    }

    @Override
    public String criarTabelaAlbuns() {
        sqlStatement = "CREATE TABLE IF NOT EXISTS albuns (" +
                "userId INTEGER, " +
                "_id INTEGER PRIMARY KEY, " +
                "titulo TEXT " +
                ");";
        return sqlStatement;
    }

    @Override
    public String criarTabelaPhotos() {
        sqlStatement = "CREATE TABLE IF NOT EXISTS fotos (" +
                "albumId INTEGER, " +
                "_id INTEGER PRIMARY KEY, " +
                "titulo TEXT, " +
                "url TEXT, " +
                "thumb TEXT " +
                ");";
        return sqlStatement;
    }

    @Override
    public String criarTabelaTarefas() {
        sqlStatement = "CREATE TABLE IF NOT EXISTS tarefas (" +
                "userId INTEGER, " +
                "_id INTEGER PRIMARY KEY, " +
                "titulo TEXT, " +
                "completed TEXT " +
                ");";
        return sqlStatement;
    }

    //
    @Override
    public String criarTabelaUser() {
        sqlStatement = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "_id INTEGER PRIMARY KEY, " +
                "nome TEXT, " +
                "login TEXT, " +
                "senha TEXT " +
                ");";
        return sqlStatement;
    }
}
