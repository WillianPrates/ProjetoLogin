package com.feldmann.projetologin.presenter;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feldmann.projetologin.adapters.UserAdapter;
import com.feldmann.projetologin.model.User;
import com.feldmann.projetologin.repository.UserDataBase;
import com.feldmann.projetologin.view.CadastroActivity;
import com.feldmann.projetologin.view.PerfilUserActivity;

public class LoginPresenter implements PresenterContract.presenterLogin{
    private static final String tagLog = "LoginPresenter";
    //
    private PresenterContract.view view;
    public LoginPresenter(PresenterContract.view view) { this.view = view; }
    //
    @Override
    public void verificaUsuario(Button btnEntrar, String login, String senha) {
        Log.d(tagLog, tagLog+"/verificaUser");
        //
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sLogin, sSenha;
                for (int i = 0; i< UserDataBase.getUsers().size(); i++){
                    User user = UserDataBase.getUsers().get(i);
                    sLogin = UserDataBase.getUsers().get(i).getLogin();
                    sSenha = UserDataBase.getUsers().get(i).getSenha();
                    //
                    if (sLogin.equals(login) && sSenha.equals(senha)){
                        usuarioValido(user);
                        break;
                    }else{
                        // não é valido
                        Log.d(tagLog, tagLog+"/USUARIO NÃO É VALIDO");
                    }
                }//fim for
            }
        });

    }//fim metodo verificaUser
    //
    @Override
    public void usuarioValido(User user) {
        Log.d(tagLog, tagLog+"/USUARIO É VALIDO");;
        Intent intent = new Intent(view.getActivity(), PerfilUserActivity.class);
        intent.putExtra("USER_OBJECT", user);
        view.getActivity().startActivity(intent);
        view.message("USUARIO VÁLIDO");
    }

    @Override
    public void telaCadastro(Button btnTelaCadastro) {
        btnTelaCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getActivity(), CadastroActivity.class);
                view.getActivity().startActivity(intent);
            }
        });
    }
}//fim classe
