package com.ahmadrosid.makananapp.core.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ahmadrosid.makananapp.R;
import com.ahmadrosid.makananapp.core.BaseFragment;
import com.ahmadrosid.makananapp.core.home.HomeActivity;
import com.eyro.mesosfer.MesosferException;
import com.eyro.mesosfer.MesosferUser;
import com.eyro.mesosfer.RegisterCallback;

import java.util.Date;

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
public class SignupFragment extends BaseFragment {

    private static final String TAG = "SignupFragment";

    @BindView(R.id.input_email) EditText input_email;
    @BindView(R.id.input_password) EditText input_password;
    @BindView(R.id.input_confirm_password) EditText confirm_password;
    @BindView(R.id.input_first_name) EditText first_name;
    @BindView(R.id.input_last_name) EditText last_name;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflate(container, R.layout.fragment_signup);
    }

    @Override public void onResume() {
        super.onResume();
        setTitle("Signup");
    }

    @OnClick(R.id.btn_register) void clickRegister(){
        if (validate()){
            showProgress();
            MesosferUser mesosferUser = MesosferUser.createUser();
            mesosferUser.setEmail(getString(input_email));
            mesosferUser.setFirstName(getString(first_name));
            mesosferUser.setLastName(getString(last_name));
            mesosferUser.setPassword(getString(input_password));
            mesosferUser.setData("dateOfBirth", new Date());

            mesosferUser.registerAsync(new RegisterCallback() {
                @Override public void done(MesosferException e) {
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
        if (isEmpty(getString(input_email))){
            showSnack("Please input your email");
        }else if (isEmpty(getString(first_name))){
            showSnack("Please input your first name");
        }else if (isEmpty(getString(last_name))){
            showSnack("Please input your last name");
        }else if (isEmpty(getString(input_password))){
            showSnack("Please input your password");
        }else if (isEmpty(getString(confirm_password))){
            showSnack("Please input confirm password");
        }else if (!getString(confirm_password).equals(getString(input_password))){
            showSnack("Your confirm password is invalid");
        }else{
            return true;
        }
        return false;
    }

}
