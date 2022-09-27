package com.feldmann.projetologin.presenter;

import android.app.Activity;
import android.widget.TextView;

public class MainPresenter {
    public interface view {
        public void message(String msg);
        public Activity getActivity();
    }
    //
    public interface presenterLogin {
        public void verificaUsuario(String login, String senha);
        public void usuarioValido(String login);
        public void telaCadastro();
    }
    //
    public interface presenterPerfil {
        public void mostraUser(String login, TextView tvId, TextView tvNome, TextView tvLogin);
    }
    //
    public interface presenterCadastro {
        public void telaLogin();
        public void criarUsuario(String nome, String login, String senha);
    }
}
