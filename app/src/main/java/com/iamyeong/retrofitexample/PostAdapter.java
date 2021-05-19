package com.iamyeong.retrofitexample;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private List<Post> posts;

    public PostAdapter(List<Post> postList) {
        this.posts = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class PostViewHolder extends RecyclerView.ViewHolder {



    public PostViewHolder(@NonNull View itemView) {
        super(itemView);



    }
}