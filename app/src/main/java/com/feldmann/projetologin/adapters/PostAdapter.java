package com.feldmann.projetologin.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.feldmann.projetologin.R;
import com.feldmann.projetologin.model.Posts;
import com.feldmann.projetologin.model.User;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //
    private List<Posts> dadosPosts;
    private List<User> dadosUser;
    /*
    public PostAdapter(List<Posts> dadosPosts, List<User> dadosUser) {
        this.dadosPosts = dadosPosts;
        this.dadosUser = dadosUser;
    }
    */
    public PostAdapter(List<Posts> dadosPosts) { this.dadosPosts = dadosPosts; }
    //
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_posts_list, parent, false);
        return new PostViewHolder(layoutViewHolder);
    }
    //
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Posts objPost = dadosPosts.get(position);
        User objUser = dadosUser.get( objPost.getUserID()-1 );
        //
        if ( objUser.getId() == objPost.getUserID() ){
            ((TextView)((PostViewHolder) holder).view.findViewById(R.id.tvNomeUserPostRV)).setText("User: "+objUser.getNome());
            ((TextView)((PostViewHolder) holder).view.findViewById(R.id.tvIdPostRV)).setText("ID: "+Integer.toString(objPost.getId() ) );
            ((TextView)((PostViewHolder) holder).view.findViewById(R.id.tvTituloPostRV)).setText("Titulo: "+objPost.getTitle());
            ((TextView)((PostViewHolder) holder).view.findViewById(R.id.tvBodyPostRV)).setText(" "+objPost.getBody());
        }
        //
    }
    //
    @Override
    public int getItemCount() {
        return dadosPosts.size();
    }
    //
}//fim class postAdapter
//
class PostViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public PostViewHolder(@NonNull View itemView){
        super(itemView);
        view = itemView;
    }
}
