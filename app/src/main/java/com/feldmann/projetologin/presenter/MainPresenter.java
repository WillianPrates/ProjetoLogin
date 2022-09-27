package com.feldmann.projetologin.presenter;

import android.app.Activity;
import android.widget.TextView;

public class MainPresenter {
    public interface view {
        public void message(String msg);
        public Activity getActivity();
        public void logUsers();
    }
    //
    public interface presenterLogin {
        public void verificaUsuario(String login, String senha);
        public void usuarioValido(String login);
    }
    //
    public interface presenterPerfil {
        public void mostraUser(String login, TextView tvId, TextView tvNome, TextView tvLogin);
    }
}
