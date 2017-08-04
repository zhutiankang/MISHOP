package com.northlight.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.northlight.latte.delegates.LatteDelegate;
import com.northlight.latte.net.RestClient;
import com.northlight.latte.net.callback.IError;
import com.northlight.latte.net.callback.IFailure;
import com.northlight.latte.net.callback.ISuccess;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/7/26 17:13
 */
public class ExampleDelegate extends LatteDelegate{
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBinderView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }
//    http://news.baidu.com/
    private void testRestClient(){
        RestClient.builder()
                .url("http://127.0.0.1/index")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Log.d("HHHHHHHHH",response);
                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
