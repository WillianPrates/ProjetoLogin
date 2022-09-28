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
        public void usuarioValido(User user);
        public void telaCadastro();
    }
    //
    public interface presenterPerfil {
        public void mostraUser(User user, TextView tvId, TextView tvNome, TextView tvLogin);
    }
    //
    public interface presenterCadastro {
        public void telaLogin();
        public void criarUsuario(String nome, String login, String senha);
    }
    //
    public interface presenterLists {
        public void setAdapterRVPosts(RecyclerView rv);
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
