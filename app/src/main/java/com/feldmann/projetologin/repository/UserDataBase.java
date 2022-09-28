package com.feldmann.projetologin.repository;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.feldmann.projetologin.model.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class UserDataBase implements Response.Listener<JSONArray>, Response.ErrorListener{
    private static final String tagLog = "UserDataBase";
    //
    private static List<User> users;
    private static UserDataBase instance = null;
    //
    private UserDataBase(Context context){
        super();
        if (users == null) {
            users = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/users";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this);
            queue.add(jaRequest);
            //
            /*
            users.add(new User(2, "fabio2", "fbo2", "1234"));
            users.add(new User(3, "fabio3", "fbo3", "1234"));
            users.add(new User(4, "fabio4", "fbo4", "1234"));
            Log.d(tagLog, "usuarios criados");
            */
        }
    }
    //
    public static List<User> getUsers(){ return users; }
    //
    public static UserDataBase getInstance(Context context) {
        //if (instance == null) {
            instance = new UserDataBase(context);
        //}
        return instance;
    }
    //
    public User getUserByLogin(String login){
        Log.d(tagLog, tagLog+"/getUserByLogin");
        User ret = null;
        for(User u : users){
            if (u.getLogin().equals(login)){
                ret = u;
            }//fim if
        }//fim for
        return ret;
    }//fim metodo
    //
    //
    @Override
    public void onResponse(JSONArray response) {
        //
        response.length();
        for (int i=0;i<response.length();i++){
            try {
                JSONObject json = response.getJSONObject(i);
                users.add(new User(
                        json.getInt("id"),
                        json.getString("name"),
                        json.getString("username"),
                        json.getString("username")
                ) );
            } catch (JSONException e) {
                e.printStackTrace();
            }//fim try catch
        }//fim for i
    }//fim onResponse
    //
    @Override
    public void onErrorResponse(VolleyError error) {
        //
        Log.e(tagLog, tagLog+"/"+error.getMessage());
    }//fim onErrorResponse

}//fim classe
