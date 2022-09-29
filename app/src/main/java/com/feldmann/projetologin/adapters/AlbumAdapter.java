package com.feldmann.projetologin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.feldmann.projetologin.R;
import com.feldmann.projetologin.model.Albuns;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //
    private List<Albuns> dadosAlbuns;
    //
    public AlbumAdapter(List<Albuns> dadosAlbuns) { this.dadosAlbuns = dadosAlbuns; }
    //
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_album_list, parent, false);
        return new AlbumViewHolder(layoutViewHolder);
    }
    //
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Albuns objAlbuns = dadosAlbuns.get(position);
        ((TextView)((AlbumViewHolder) holder).view.findViewById(R.id.tvUserIdAlbum)).setText("User: "+Integer.toString(objAlbuns.getUserID()));
        ((TextView)((AlbumViewHolder) holder).view.findViewById(R.id.tvIdAlbum)).setText("ID: "+Integer.toString(objAlbuns.getId()));
        ((TextView)((AlbumViewHolder) holder).view.findViewById(R.id.tvTituloAlbum)).setText("Titulo: "+ objAlbuns.getTitle());
    }
    //
    @Override
    public int getItemCount() { return dadosAlbuns.size(); }
    //
}
class AlbumViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public AlbumViewHolder(@NonNull View itemView){
        super(itemView);
        view = itemView;
    }
}