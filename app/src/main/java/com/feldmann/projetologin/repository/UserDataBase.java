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
    private SQLiteDatabase sqlWrite;
    private static List<User> users;

    public UserDataBase(Context context, SQLiteDatabase sqlWrite) {
        super();
        this.sqlWrite = sqlWrite;
        Log.d(tagLog, "Construtor");
        //
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
    public static UserDataBase getInstance(Context context, SQLiteDatabase sqlWrite) {
        instance = new UserDataBase(context, sqlWrite);
        return instance;
    }
    //
    public static List<User> getUsers(){ return users; }
    //
    @Override
    public void onErrorResponse(VolleyError error) { Log.e(tagLog, ""+error.getMessage()); }
    //
    @Override
    public void onResponse(JSONArray response) {
        ContentValues ctv;
        JSONObject json;
        for (int i=0;i<=response.length();i++){
            try {
                json = response.getJSONObject(i);
                users.add(new User(
                        json.getInt("id"),
                        json.getString("name"),
                        json.getString("username"),
                        json.getString("username")
                ) );
                //
            } catch (JSONException e) {
                Log.e("onResponse", "Erro ao adicionar no List: "+e.getMessage() );
            }//fim try catch
            //
            try {
                ctv = new ContentValues();
                json = response.getJSONObject(i);
                //
                ctv.put("_id", json.getInt("id") );
                ctv.put("nome", json.getString("name") );
                ctv.put("login", json.getString("username") );
                ctv.put("senha", json.getString("username") );
                sqlWrite.insert("usuarios", null, ctv);
                //
            } catch (JSONException e) {
                Log.e("onResponse", "Erro ao adicionar no DB: "+e.getMessage() );
            }//fim try catch
        }//fim for i
    }//fim onResponse
}//fim classe