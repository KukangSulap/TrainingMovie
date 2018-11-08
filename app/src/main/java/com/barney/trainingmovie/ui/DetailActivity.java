package com.barney.trainingmovie.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.barney.trainingmovie.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.backdropImage)
    ImageView backdropImage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    String header, deskripsi, gambar, backdrop, rating, backdrop10;
    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.belakang)
    ImageView belakang;
    @BindView(R.id.rate)
    TextView rate;
    @BindView(R.id.isi)
    TextView isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        header = getIntent().getStringExtra("nama");
        deskripsi = getIntent().getStringExtra("keterangan");
        gambar = getIntent().getStringExtra("gambar");
        backdrop = getIntent().getStringExtra("backdrop");
        backdrop10 = getIntent().getStringExtra("backdrop1");
        rating = String.valueOf(getIntent().getDoubleExtra("rating", 0));

        Glide.with(DetailActivity.this)
                .load(gambar)
                .apply(RequestOptions.fitCenterTransform())
                .into(image1);

        Glide.with(DetailActivity.this)
                .load(backdrop)
                .apply(RequestOptions.fitCenterTransform())
                .into(backdropImage);

        Glide.with(DetailActivity.this)
                .load(backdrop10)
                .apply(RequestOptions.fitCenterTransform())
                .into(belakang);

        Log.d("nama", header);
        setTitle(header);
        rate.setText("Rating : " + rating);
        toolbar.setTitle(header);
        isi.setText(deskripsi);
//        txtHeader.setText(header);
//        Description.setText(deskripsi);
    }
}
