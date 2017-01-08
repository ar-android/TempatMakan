package com.ahmadrosid.makananapp.core.welcome;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.ahmadrosid.makananapp.R;
import com.ahmadrosid.makananapp.core.BaseActivity;

/**
 * Created by ocittwo on 1/7/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class SplashScreen extends BaseActivity{
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                open(WelcomeActivity.class);
                finish();
            }
        }, 2500);
    }
}
