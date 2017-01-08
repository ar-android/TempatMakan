package com.ahmadrosid.makananapp.core.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.makananapp.R;
import com.ahmadrosid.makananapp.data.DiscoverMakanan;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ocittwo on 1/8/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class DiscoverMakananHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.img_discover)ImageView img_discover;
    @BindView(R.id.name) TextView name;
    @BindView(R.id.descriptions) TextView descriptions;

    public DiscoverMakananHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(DiscoverMakanan data){
        Glide.with(itemView.getContext()).load(data.img_url).centerCrop().into(img_discover);
        name.setText(data.name);
        descriptions.setText(data.descriptions);
    }
}
