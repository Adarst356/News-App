package com.devdroid.abp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.devdroid.abp.Activity.WebViewActivity;
import com.devdroid.abp.ModelClass.NewsClass;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<NewsClass> NewsClassArrayList;

    public Adapter(Context context, ArrayList<NewsClass> newsClassArrayList) {
        this.context = context;
        this.NewsClassArrayList = newsClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        NewsClass news = NewsClassArrayList.get(position);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("url", news.getUrl());
                context.startActivity(intent);
            }
        });

        holder.time.setText("Published At: " + news.getPublishedAt());
        holder.author.setText(news.getAuthor());
        holder.heading.setText(news.getTitle());
        holder.content.setText(news.getDescription());

        Glide.with(context).load(news.getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return NewsClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading, content, author, time;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.mainheading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.imageview);
        }
    }
}
