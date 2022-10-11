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
import com.feldmann.projetologin.model.Comments;
import com.feldmann.projetologin.model.Photos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
//
public class PhotosDataBase implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "PhotosDataBase";
    //
    private static List<Photos> photos;
    private static PhotosDataBase instance = null;
    private SQLiteDatabase sqlWrite;
    //
    private PhotosDataBase(Context context, SQLiteDatabase sqlWrite){
        super();
        this.sqlWrite = sqlWrite;
        if ( photos == null ) {
            photos = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/photos";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this);
            queue.add(jaRequest);
        }
    }
    //
    public static List<Photos> getPhotos() { return photos; }
    //
    public static PhotosDataBase getInstance(Context context, SQLiteDatabase sqlWrite){
        instance = new PhotosDataBase(context, sqlWrite);
        return instance;
    }
    //
    @Override
    public void onErrorResponse(VolleyError error) { Log.e(tagLog, tagLog+"/"+error.getMessage()); }
    //
    @Override
    public void onResponse(JSONArray response) {
        ContentValues ctv;
        JSONObject json;
        for (int i=0;i< response.length();i++){
            try{
                json = response.getJSONObject(i);
                photos.add( new Photos(
                        json.getInt("albumId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("url"),
                        json.getString("thumbnailUrl")
                )/* fim new photos */ ); //fim add
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
            try{
                ctv = new ContentValues();
                json = response.getJSONObject(i);
                //
                ctv.put("albumId", json.getInt("albumId") );
                ctv.put("_id", json.getInt("id") );
                ctv.put("titulo", json.getString("title") );
                ctv.put("url", json.getString("url") );
                ctv.put("thumb", json.getString("thumbnailUrl") );
                sqlWrite.insert("usuarios", null, ctv);
            }catch (JSONException e){
                e.printStackTrace();
            }//fim try catch
        }//fim for i
    }//fim onResponse
}//fim classe
