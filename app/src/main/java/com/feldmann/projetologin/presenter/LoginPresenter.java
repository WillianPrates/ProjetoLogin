package com.feldmann.projetologin.presenter;

import android.content.Intent;
import android.util.Log;

import com.feldmann.projetologin.model.User;
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
        for (int i = 0; i< User.getUsers().size(); i++){
            sLogin = User.getUsers().get(i).getLogin();
            sSenha = User.getUsers().get(i).getSenha();

            Log.d("LoginActivity", "EditText:\n"+
                    "login: "+login+" | senha: "+senha+"\n"+
                    "List:\n"+
                    "login: "+sLogin+" | senha: "+sSenha+"\n");

            if (sLogin.equals(login) && sSenha.equals(senha)){
                // é valido
                Log.d(tagLog, tagLog+"/USUARIO É VALIDO");;
                Intent intent = new Intent(view.getActivity(), PerfilUserActivity.class);
                intent.putExtra("LOGIN", sLogin);
                view.getActivity().startActivity(intent);
                view.message("USUARIO VÁLIDO");
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
        //
    }
}
