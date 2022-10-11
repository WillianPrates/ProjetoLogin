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
    private SQLiteDatabase sqlWrite;
    //
    private AlbunsDataBase(Context context, SQLiteDatabase sqlWrite){
        super();
        this.sqlWrite = sqlWrite;
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
    public static List<Albuns> getAlbuns() { return albuns; }
    //
    public static AlbunsDataBase getInstance(Context context, SQLiteDatabase sqlWrite){
        instance = new AlbunsDataBase(context, sqlWrite);
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
        ContentValues ctv;
        JSONObject json;
        for (int i=0;i< response.length();i++){
            try{
                json = response.getJSONObject(i);
                albuns.add( new Albuns(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title")
                )/* fim new albuns */ ); //fim add
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
            try{
                ctv = new ContentValues();
                json = response.getJSONObject(i);
                //
                ctv.put("userId", json.getInt("userId") );
                ctv.put("_id", json.getInt("id") );
                ctv.put("titulo", json.getString("title") );
                //
                sqlWrite.insert("albuns", null, ctv);
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
        }//fim for i
    }//fim onResponse
}//fim classe