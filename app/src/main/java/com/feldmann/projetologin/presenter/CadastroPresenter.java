package com.feldmann.projetologin.presenter;


import android.content.Intent;

import com.feldmann.projetologin.model.User;
import com.feldmann.projetologin.repository.UserDataBase;
import com.feldmann.projetologin.view.LoginActivity;

import java.util.List;

public class CadastroPresenter implements PresenterContract.presenterCadastro {
    private static final String tagLog = "CadastroPresenter";
    //
    private PresenterContract.view view;
    public CadastroPresenter(PresenterContract.view view) { this.view = view; }
    //
    @Override
    public void telaLogin() {
        Intent intent = new Intent(view.getActivity(), LoginActivity.class);
        view.getActivity().startActivity(intent);
    }

    @Override
    public void criarUsuario(String nome, String login, String senha) {
        List<User> users = UserDataBase.getUsers();
        users.add(new User(users.size()+1, nome, login, senha));
        this.telaLogin();
        view.message("USUARIO CRIADO");
    }
}
