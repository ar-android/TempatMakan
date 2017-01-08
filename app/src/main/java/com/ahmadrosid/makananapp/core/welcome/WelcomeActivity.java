package com.ahmadrosid.makananapp.core.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.ahmadrosid.makananapp.R;
import com.ahmadrosid.makananapp.core.BaseActivity;
import com.ahmadrosid.makananapp.core.home.HomeActivity;
import com.eyro.mesosfer.MesosferUser;

/**
 * Created by ocittwo on 1/7/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class WelcomeActivity extends BaseActivity {
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setToolbar();

        MesosferUser user = MesosferUser.getCurrentUser();
        if (user != null) {
            open(HomeActivity.class);
            finish();
        } else {
            setActiveFragment(new WelcomeFragment());
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
