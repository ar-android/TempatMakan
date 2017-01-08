package com.ahmadrosid.makananapp.core.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ahmadrosid.makananapp.R;
import com.ahmadrosid.makananapp.core.BaseFragment;
import com.ahmadrosid.makananapp.core.home.HomeActivity;
import com.eyro.mesosfer.LogInCallback;
import com.eyro.mesosfer.MesosferException;
import com.eyro.mesosfer.MesosferUser;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ocittwo on 1/7/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class SigninFragment extends BaseFragment {
    private static final String TAG = "SigninFragment";

    @BindView(R.id.input_email) EditText input_email;
    @BindView(R.id.input_password) EditText input_password;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflate(container, R.layout.fragment_signin);
    }

    @Override public void onResume() {
        super.onResume();
        setTitle("Signin");
    }

    @OnClick(R.id.btn_login) void clickLogin(){
        if (validate()){
            showProgress();
            MesosferUser.logInAsync(getString(input_email), getString(input_password), new LogInCallback() {
                @Override public void done(MesosferUser mesosferUser, MesosferException e) {
                    if (e == null){
                        open(HomeActivity.class);
                        finish();
                    }else{
                        Log.e(TAG, "done: ", e);
                        showSnack(e.getMessage());
                    }
                    hideProgress();
                }
            });
        }
    }

    private boolean validate() {
        if (TextUtils.isEmpty(getString(input_email))){
            showSnack("Please input your email.");
        }else if (TextUtils.isEmpty(getString(input_password))){
            showSnack("Please input your password.");
        }else{
            return true;
        }
        return false;
    }
}
