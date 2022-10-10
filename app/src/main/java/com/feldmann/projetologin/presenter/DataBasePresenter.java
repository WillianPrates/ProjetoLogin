package com.feldmann.projetologin.presenter;

public class DataBasePresenter implements PresenterContract.presenterDB{
    //
    private PresenterContract.view view;
    public DataBasePresenter(PresenterContract.view view) { this.view = view; }
    //
    @Override
    public String criarTabelaUser() {
        String sqlUsers = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "_id INTEGER PRIMARY KEY, " +
                "nome VARCHAR(255)," +
                "login VARCHAR(255)," +
                "senha VARCHAR(255)" +
                ");";
        return sqlUsers;
    }
}
