package com.feldmann.projetologin.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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

public class UserDataBase implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "UserDataBase";
    private static UserDataBase instance = null;
    private SQLiteDatabase sql;
    private static List<User> users;

    public UserDataBase(Context context, SQLiteDatabase sql) {
        super();
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://jsonplaceholder.typicode.com/users";
        JsonArrayRequest jaRequest = new JsonArrayRequest(
                Request.Method.GET, url,
                null, this, this);
        queue.add(jaRequest);
        this.sql = sql;
    }
    //
    public static UserDataBase getInstance(Context context, SQLiteDatabase sqLite) {
        instance = new UserDataBase(context, sqLite);
        return instance;
    }
    //
    public void setUsers(JSONObject json){
        if (users == null){
            users = new ArrayList<>();
            users.add(new User(
                    json.get("id"),
                    json.getString("name"),
                    json.getString("username"),
                    json.getString("username")
            ) );
        }
    }
    //
    public static List<User> getUsers(){ return users; }
    //
    @Override
    public void onErrorResponse(VolleyError error) { Log.e(tagLog, tagLog+"/"+error.getMessage()); }
    //
    @Override
    public void onResponse(JSONArray response) {
        Log.d(tagLog, "tamanho do response: "+response.length() );
        for (int i=0;i<response.length();i++){
            try {
                JSONObject json = response.getJSONObject(i);
                ContentValues ctv;
                //
                setUsers(json);
                //
                ctv = new ContentValues();
                ctv.put("id", json.getInt("id"));
                ctv.put("nome", json.getString("name"));
                ctv.put("login", json.getString("username"));
                ctv.put("senha", json.getString("username"));
                sql.insert("usuarios", null, ctv);
                //
            } catch (JSONException e) {
                e.printStackTrace();
            }//fim try catch
        }//fim for i
    }
    //
}


/*
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
    @Override
    public void onResponse(JSONArray response) {
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
*/