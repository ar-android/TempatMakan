package com.ahmadrosid.makananapp.core.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ahmadrosid.makananapp.R;
import com.ahmadrosid.makananapp.core.BaseActivity;
import com.ahmadrosid.makananapp.core.favourite.FavouriteFragment;
import com.ahmadrosid.makananapp.core.nearby.NearbyFragment;
import com.ahmadrosid.makananapp.core.profile.ProfileFragment;
import com.ahmadrosid.makananapp.core.welcome.WelcomeActivity;
import com.eyro.mesosfer.LogOutCallback;
import com.eyro.mesosfer.MesosferException;
import com.eyro.mesosfer.MesosferUser;

/**
 * Created by ocittwo on 1/8/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class HomeActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "HomeActivity";
    private BottomNavigationView bottomNavigationView;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        setToolbar();
        setActiveFragment(new HomeFragment());
        setTitle("Tempat Makan");
        setBottomNav();
    }

    private void setBottomNav(){
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_logout:
                showProgress();
                MesosferUser.logOutAsync(new LogOutCallback() {
                    @Override public void done(MesosferException e) {
                        hideProgress();
                        if (e == null){
                            open(WelcomeActivity.class);
                            finish();
                        }else{
                            Log.e(TAG, "done: ", e);
                        }
                    }
                });
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.recents:
                setActiveFragment(new HomeFragment());
                break;
            case R.id.nearby:
                setActiveFragment(new NearbyFragment());
                break;
            case R.id.favoutire:
                setActiveFragment(new FavouriteFragment());
                break;
            case R.id.profile:
                setActiveFragment(new ProfileFragment());
                break;
        }
        return true;
    }
}
