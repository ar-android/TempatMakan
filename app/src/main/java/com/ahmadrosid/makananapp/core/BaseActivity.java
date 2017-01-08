package com.ahmadrosid.makananapp.core;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.ahmadrosid.makananapp.R;

/**
 * Created by ocittwo on 1/7/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class BaseActivity extends AppCompatActivity{
    private static final String TAG = "BaseActivity";

    private ProgressDialog progressDialog;

    public void setToolbar(){
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }catch (Exception e){
            Log.e(TAG, "setToolbar: ", e);
        }
    }

    @Override protected void onStart() {
        super.onStart();
        if (progressDialog == null)
            progressDialog = new ProgressDialog(this);
    }

    protected void showProgress(){
        if (!progressDialog.isShowing()){
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }
    }

    protected void hideProgress(){
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    public void setActiveFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void open(Class clazz){
        startActivity(new Intent(this, clazz));
    }
}
