package com.feldmann.projetologin.presenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PresenterContract {
    public interface view {
        public void message(String msg);
        public Activity getActivity();
    }
    //
    public interface presenterMain {
        public void paraTelaLogin(Button TelaLogin);
        public void paraListPosts(Button ListPost);
        public void paraListComments(Button ListComment);
        public void paraListAlbuns(Button ListAlbum);
        public void paraListPhotos(Button ListPhoto);
        public void paraListTodos(Button ListTodo);
        public void paraListUsers(Button ListUser);
    }
    //
    public interface presenterLogin {
        public void verificaUsuario(String login, String senha);
        public void usuarioValido(String login);
        public void telaCadastro();
        public void setAdapterRV(RecyclerView rv);
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
    //
}
