package com.ahmadrosid.makananapp.core.home;

import android.support.v7.widget.RecyclerView;

import com.ahmadrosid.makananapp.core.BasePresenter;
import com.ahmadrosid.makananapp.core.BaseView;

/**
 * Created by ocittwo on 1/8/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public interface HomeConstruct {
    interface View extends BaseView{
        void setListDiscover(RecyclerView.Adapter adapter);
        void setListMenu(RecyclerView.Adapter adapter);
    }
    interface Presenter extends BasePresenter{
        void loadDiscover();
        void setupMenuMakanan();
    }
}