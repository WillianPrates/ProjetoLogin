package com.feldmann.projetologin.repository;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.feldmann.projetologin.model.Albuns;
import com.feldmann.projetologin.model.Comments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AlbunsDataBase implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "AlbunsDataBase";
    //
    private static List<Albuns> albuns;
    private static AlbunsDataBase instance = null;
    //
    private AlbunsDataBase(Context context){
        super();
        if (albuns == null){
            albuns = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/albums";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this );
            queue.add(jaRequest);
        }
    }
    //
    public List<Albuns> getAlbuns() { return albuns; }
    //
    public static  AlbunsDataBase getInstance(Context context){
        instance = new AlbunsDataBase(context);
        return instance;
    }
    //
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e(tagLog, tagLog+"/"+error.getMessage());
    }
    //
    @Override
    public void onResponse(JSONArray response) {
        for (int i=0;i< response.length();i++){
            try{
                JSONObject json = response.getJSONObject(i);
                albuns.add( new Albuns(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title")
                )/* fim new albuns */ ); //fim add
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
        }//fim for i
    }//fim onResponse
}//fim class
