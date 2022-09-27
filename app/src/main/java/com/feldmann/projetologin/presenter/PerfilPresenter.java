package com.feldmann.projetologin.presenter;

import android.widget.TextView;

import com.feldmann.projetologin.model.User;
import com.feldmann.projetologin.repository.UserDataBase;

public class PerfilPresenter implements PresenterContract.presenterPerfil{
    private static final String tagLog = "PerfilPresenter";
    //
    private PresenterContract.view view;
    public PerfilPresenter(PresenterContract.view view) { this.view = view; }
    @Override
    public void mostraUser(String login, TextView tvId, TextView tvNome, TextView tvLogin) {

        UserDataBase db = UserDataBase.getInstance(view.getActivity());
        User user = db.getUserByLogin(login);
        //
        tvId.setText("ID: "+String.valueOf(user.getId()));
        tvNome.setText("NOME: "+user.getNome());
        tvLogin.setText("Login: "+user.getLogin());
    }
}
