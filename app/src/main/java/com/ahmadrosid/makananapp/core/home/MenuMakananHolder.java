package com.ahmadrosid.makananapp.core.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.makananapp.R;
import com.ahmadrosid.makananapp.data.MenuMakanan;
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
public class MenuMakananHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.item_icon)ImageView item_icon;
    @BindView(R.id.item_name)TextView item_name;

    public MenuMakananHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(MenuMakanan data){
        Glide.with(itemView.getContext()).load(data.iconRes).into(item_icon);
        item_name.setText(data.name);
    }
}
