package com.barney.trainingmovie.ui;

import android.content.Context;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama.setText(resultsItems.get(position).getTitle());
        holder.keterangan.setText(resultsItems.get(position).getOverview());
        holder.tglRilis.setText(resultsItems.get(position).getReleaseDate());
        Glide.with(context)
                .load(resultsItems.get(position).getPosterPath())
                .into(holder.image);
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
            keterangan = itemView.findViewById(R.id.keterangan);
            tglRilis = itemView.findViewById(R.id.tglRilis);
            image = itemView.findViewById(R.id.urlToImage);
        }

    }

//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.listitem, null);
//        return new MyViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.nama.setText(resultsItems.get(position).getTitle());
//        holder.keterangan.setText(resultsItems.get(position).getOverview());
//        holder.tglRilis.setText(resultsItems.get(position).getReleaseDate());
//        Glide.with(context)
//                .load(resultsItems.get(position).getPosterPath())
//                .into(holder.image);
//    }

    }

