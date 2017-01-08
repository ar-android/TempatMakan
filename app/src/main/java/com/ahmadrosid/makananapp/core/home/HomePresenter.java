package com.ahmadrosid.makananapp.core.home;

import android.util.Log;

import com.ahmadrosid.makananapp.R;
import com.ahmadrosid.makananapp.data.DiscoverMakanan;
import com.ahmadrosid.makananapp.data.MenuMakanan;
import com.ahmadrosid.makananapp.helper.RecyclerAdapter;
import com.eyro.mesosfer.FindCallback;
import com.eyro.mesosfer.MesosferData;
import com.eyro.mesosfer.MesosferException;
import com.eyro.mesosfer.MesosferQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ocittwo on 1/8/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class HomePresenter implements HomeConstruct.Presenter {
    private static final String TAG = "HomePresenter";

    private HomeConstruct.View view;
    private List<MenuMakanan> menuMakananList;
    private List<DiscoverMakanan> discoverMakananList;
    private RecyclerAdapter<MenuMakanan, MenuMakananHolder> adapterMenu;
    private RecyclerAdapter<DiscoverMakanan, DiscoverMakananHolder> adapterDiscover;

    public HomePresenter(HomeConstruct.View view) {
        this.view = view;
        menuMakananList = new ArrayList<>();
        discoverMakananList = new ArrayList<>();
    }

    @Override public void loadDiscover() {
        view.showLoading();
        MesosferQuery<MesosferData> mesosferData = MesosferData.getQuery("Discover");
        mesosferData.findAsync(new FindCallback<MesosferData>() {
            @Override public void done(List<MesosferData> list, MesosferException e) {
                view.hideLoading();
                if (e == null){
                    for (MesosferData data : list) {
                        discoverMakananList.add(new DiscoverMakanan(
                                data.getDataString("name"),
                                data.getDataString("imgUrl"),
                                data.getDataString("description"),
                                null
                        ));
                    }
                    setDiscoverMakananList(discoverMakananList);
                }else{
                    Log.e(TAG, "done: ", e);
                }
            }
        });
    }

    public void setDiscoverMakananList(List<DiscoverMakanan> data) {
        adapterDiscover = new RecyclerAdapter<DiscoverMakanan, DiscoverMakananHolder>(
                data, DiscoverMakanan.class, DiscoverMakananHolder.class,
                R.layout.item_discover_makanan
        ) {
            @Override protected void bindHolder(DiscoverMakananHolder holder, DiscoverMakanan data, int position) {
                holder.bind(data);
                Log.d(TAG, "bindHolder: " + data.name);
            }
        };
        view.setListDiscover(adapterDiscover);
    }

    @Override public void setupMenuMakanan() {
        menuMakananList.add(new MenuMakanan("Breakfast", R.drawable.breakfast));
        menuMakananList.add(new MenuMakanan("Lunch", R.drawable.lunch));
        menuMakananList.add(new MenuMakanan("Dinner", R.drawable.dinner));
        menuMakananList.add(new MenuMakanan("Delivery", R.drawable.delivery));
        menuMakananList.add(new MenuMakanan("Desserts", R.drawable.desserts));
        menuMakananList.add(new MenuMakanan("Luxury Dinning", R.drawable.luxury_dining));
        menuMakananList.add(new MenuMakanan("Cafe", R.drawable.cafe));
        menuMakananList.add(new MenuMakanan("Drink & Nightlife", R.drawable.drink_nightlife));

        adapterMenu = new RecyclerAdapter<MenuMakanan, MenuMakananHolder>(menuMakananList, MenuMakanan.class,
                MenuMakananHolder.class, R.layout.item_menu_makanan) {
            @Override protected void bindHolder(MenuMakananHolder holder, MenuMakanan data, int position) {
                holder.bind(data);
            }
        };

        view.setListMenu(adapterMenu);
    }

    @Override public void onDetach() {
        view = null;
    }
}
