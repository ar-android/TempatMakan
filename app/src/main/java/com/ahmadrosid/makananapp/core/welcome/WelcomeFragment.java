package com.ahmadrosid.makananapp.core.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmadrosid.makananapp.R;
import com.ahmadrosid.makananapp.core.BaseFragment;

import butterknife.OnClick;

/**
 * Created by ocittwo on 1/7/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class WelcomeFragment extends BaseFragment{

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflate(container, R.layout.fragment_welcome);
    }

    @Override public void onResume() {
        super.onResume();
        setTitle("Welcome");
    }

    @OnClick(R.id.btn_signin) void clickSignin(){
        setActiveFragment(new SigninFragment());
    }

    @OnClick(R.id.btn_signup) void clickSignup(){
        setActiveFragment(new SignupFragment());
    }

}
