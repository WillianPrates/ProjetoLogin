package com.feldmann.projetologin.presenter;

import android.content.Intent;
import android.service.autofill.UserData;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feldmann.projetologin.R;
import com.feldmann.projetologin.adapters.UserAdapter;
import com.feldmann.projetologin.model.User;
import com.feldmann.projetologin.repository.UserDataBase;
import com.feldmann.projetologin.view.CadastroActivity;
import com.feldmann.projetologin.view.PerfilUserActivity;

public class LoginPresenter implements MainPresenter.presenterLogin{
    private static final String tagLog = "LoginPresenter";
    //
    private MainPresenter.view view;
    public LoginPresenter(MainPresenter.view view) { this.view = view; }
    //
    @Override
    public void verificaUsuario(String login, String senha) {
        Log.d(tagLog, tagLog+"/verificaUser");
        //
        String sLogin, sSenha;
        for (int i = 0; i< UserDataBase.getUsers().size(); i++){
            sLogin = UserDataBase.getUsers().get(i).getLogin();
            sSenha = UserDataBase.getUsers().get(i).getSenha();
            //
            if (sLogin.equals(login) && sSenha.equals(senha)){
                this.usuarioValido(sLogin);
                break;
            }else{
                // não é valido
                Log.d(tagLog, tagLog+"/USUARIO NÃO É VALIDO");
            }
        }//fim for
    }//fim metodo verificaUser
    //
    @Override
    public void usuarioValido(String login) {
        Log.d(tagLog, tagLog+"/USUARIO É VALIDO");;
        Intent intent = new Intent(view.getActivity(), PerfilUserActivity.class);
        intent.putExtra("LOGIN", login);
        view.getActivity().startActivity(intent);
        view.message("USUARIO VÁLIDO");
    }

    @Override
    public void telaCadastro() {
        Intent intent = new Intent(view.getActivity(), CadastroActivity.class);
        view.getActivity().startActivity(intent);
    }

    @Override
    public void setAdapterRV(RecyclerView rv) {
        UserAdapter adapter = new UserAdapter(UserDataBase.getUsers());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(view.getActivity()));
    }
}
