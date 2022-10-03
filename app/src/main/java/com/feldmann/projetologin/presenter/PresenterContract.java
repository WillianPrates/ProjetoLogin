package com.feldmann.projetologin.presenter;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.feldmann.projetologin.model.User;
//
public class PresenterContract {
    public interface view {
        public void message(String msg);
        public Activity getActivity();
    }
    //
    public interface presenterMain {
    }
    //
    public interface presenterLogin {
        public void verificaUsuario(String login, String senha);
        public void usuarioValido(User user);
        public void telaCadastro();
    }
    //
    public interface presenterPerfil {
        public void paraListAlbuns(Button ListAlbum);
        public void paraListPosts(Button ListPost, String idUser, String nomeUser);
        public void paraListTodos(Button ListTodo);
    }
    //
    public interface presenterCadastro {
        public void telaLogin();
        public void criarUsuario(String nome, String login, String senha);
    }
    //
    public interface presenterLists {
        public void setAdapterRVPosts(RecyclerView rv, String idUser, String nomeUser);
        public void setAdapterRVComments(RecyclerView rv);
        public void setAdapterRVAlbuns(RecyclerView rv);
        public void setAdapterRVPhotos(RecyclerView rv);
        public void setAdapterRVTodos(RecyclerView rv);
        public void setAdapterRVUsers(RecyclerView rv);
        // criar repositorios e adapters para cada um das views
        // e colocar aqui os setadapters pra cada um deles
    }
    //
}
