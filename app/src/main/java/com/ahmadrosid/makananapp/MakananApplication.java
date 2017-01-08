package com.ahmadrosid.makananapp;

import android.app.Application;

import com.eyro.mesosfer.Mesosfer;

/**
 * Created by ocittwo on 1/7/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class MakananApplication extends Application{

    private final String APP_ID = "YOUR APP ID";
    private final String APP_KEY = "YOUR APP KEY";

    @Override public void onCreate() {
        super.onCreate();
        Mesosfer.initialize(this, APP_ID, APP_KEY);
        Mesosfer.setLogLevel(Mesosfer.LOG_LEVEL_DEBUG);
    }

}
