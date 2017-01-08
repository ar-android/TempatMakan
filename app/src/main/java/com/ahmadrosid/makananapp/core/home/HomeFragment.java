package com.ahmadrosid.makananapp.core.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmadrosid.makananapp.R;
import com.ahmadrosid.makananapp.core.BaseFragment;

import butterknife.BindView;

/**
 * Created by ocittwo on 1/8/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class HomeFragment extends BaseFragment implements HomeConstruct.View{

    @BindView(R.id.list_menu_makanan)RecyclerView list_menu_makanan;
    @BindView(R.id.list_discover)RecyclerView list_discover;

    private HomePresenter presenter;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflate(container, R.layout.fragment_home);
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new HomePresenter(this);
        presenter.loadDiscover();
        presenter.setupMenuMakanan();
    }

    @Override public void setListDiscover(RecyclerView.Adapter adapter) {
        list_discover.setHasFixedSize(true);
        list_discover.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        list_discover.setAdapter(adapter);

//        SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
//        snapHelperStart.attachToRecyclerView(list_discover);
    }

    @Override public void setListMenu(RecyclerView.Adapter adapter) {
        list_menu_makanan.setHasFixedSize(true);
        list_menu_makanan.setLayoutManager(new GridLayoutManager(getContext(), 2));
        list_menu_makanan.setAdapter(adapter);
    }

    @Override public void showLoading() {
        showProgress();
    }

    @Override public void hideLoading() {
        hideProgress();
    }

    @Override public void onStop() {
        super.onStop();
        presenter.onDetach();
    }
}
