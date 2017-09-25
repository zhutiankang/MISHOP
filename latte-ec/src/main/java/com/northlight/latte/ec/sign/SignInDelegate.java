package com.northlight.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.northlight.latte.delegates.LatteDelegate;
import com.northlight.latte.ec.R;
import com.northlight.latte.ec.R2;
import com.northlight.latte.net.RestClient;
import com.northlight.latte.net.callback.ISuccess;
import com.northlight.latte.util.log.LatteLogger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/9/11 13:50
 */

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    private ISignListener mSignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener){
            mSignListener = (ISignListener)activity;
        }
    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn(){
        if (checkForm()){
            RestClient.builder()
                    .url("http://192.168.42.165:8080/RestServer/api/user_profile.php")
                    .params("email",mEmail.getText().toString())
                    .params("password",mPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE",response);
                            SignHandler.onSignIn(response,mSignListener);
                        }
                    })
                    .build()
                    .post();

        }
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat(){

    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink(){
        start(new SignUpDelegate());
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBinderView(@Nullable Bundle savedInstanceState, View rootView) {
//        LatteLogger.d(this.toString());
    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        }else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }
}
