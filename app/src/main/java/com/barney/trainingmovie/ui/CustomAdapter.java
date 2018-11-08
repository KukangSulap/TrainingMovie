package com.barney.trainingmovie.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.barney.trainingmovie.R;
import com.barney.trainingmovie.model.ResultsItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    List<ResultsItem> resultsItems;
    Context context;

    public CustomAdapter(List<ResultsItem> resultsItems, MainActivity mainActivity) {
        this.resultsItems = resultsItems;
        this.context = mainActivity;
    }

    @NonNull
    @Override
    public
    MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.listitem, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.nama.setText(resultsItems.get(position).getTitle());
//        holder.keterangan.setText(resultsItems.get(position).getOverview());
//        holder.tglRilis.setText(resultsItems.get(position).getReleaseDate());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" +resultsItems.get(position).getPosterPath())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("nama", resultsItems.get(position).getTitle());
                intent.putExtra("keterangan", resultsItems.get(position).getOverview());
                intent.putExtra("rating", resultsItems.get(position).getVoteAverage());
//                intent.putExtra("tglRilis", resultsItems.get(position).getReleaseDate());
                intent.putExtra("backdrop","https://image.tmdb.org/t/p/w500" +resultsItems.get(position).getBackdropPath());
                intent.putExtra("backdrop1","https://image.tmdb.org/t/p/w500" +resultsItems.get(position).getBackdropPath());
                intent.putExtra("gambar" ,"https://image.tmdb.org/t/p/w500" +resultsItems.get(position).getPosterPath());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView nama, keterangan, tglRilis;

        public MyViewHolder(View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.nama);
//            keterangan = itemView.findViewById(R.id.keterangan);
//            tglRilis = itemView.findViewById(R.id.tglRilis);
//            image = itemView.findViewById(R.id.urlToImage);
            image = itemView.findViewById(R.id.imgposterr);
        }

    }


    }

