package com.feldmann.projetologin.presenter;

import android.content.Intent;

import com.feldmann.projetologin.view.CadastroActivity;

public class DataBasePresenter implements MainPresenter.presenterDataBase{
    private MainPresenter.view view;
    public DataBasePresenter(MainPresenter.view view) { this.view = view; }
    @Override
    public void telaCadastro() {
        Intent intent = new Intent(view.getActivity(), CadastroActivity.class);
        view.getActivity().startActivity(intent);
    }

    @Override
    public void criarUsuario(String nome, String login, String senha) {

    }
}
