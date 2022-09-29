package com.feldmann.projetologin.adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.feldmann.projetologin.R;
import com.feldmann.projetologin.model.Photos;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //
    private List<Photos> dadosPhotos;
    //
    public PhotoAdapter(List<Photos> dadosPhotos) { this.dadosPhotos = dadosPhotos; }
    //
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_photos_list, parent, false);
        return new PhotoViewHolder(layoutViewHolder);
    }
    //
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //
        Photos objPhoto = dadosPhotos.get(position);
        //
        ((TextView)((PhotoViewHolder) holder).view.findViewById(R.id.tvIdAlbumPhoto)).setText("ID Album: "+ Integer.toString(objPhoto.getAlbumID()) );
        ((TextView)((PhotoViewHolder) holder).view.findViewById(R.id.tvIdPhoto)).setText("ID: "+Integer.toString(objPhoto.getId()));
        ((TextView)((PhotoViewHolder) holder).view.findViewById(R.id.tvTituloPhoto)).setText("Titulo: "+objPhoto.getTitle());
        Picasso.get().load(objPhoto.getThumbnailURL()).into(
                ((ImageView)((PhotoViewHolder) holder).view.findViewById(R.id.image150))
        );
        Picasso.get().load(objPhoto.getUrl()).into(
                ((ImageView)((PhotoViewHolder) holder).view.findViewById(R.id.image600))
        );
    }
    //
    @Override
    public int getItemCount() { return dadosPhotos.size(); }
    //
}
class PhotoViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public PhotoViewHolder(@NonNull View itemView){
        super(itemView);
        view = itemView;
    }
}