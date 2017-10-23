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
//    http://news.baidu.com/    http://127.0.0.1/index【Debug拦截器】   base_url与url以 http://为分界线，如果url中有http://就用url不组合base_url   否则组合
    private void testRestClient(){
        //1. 有http://, 完整url,不需要与base_url组合
        RestClient.builder()
                .url("http://192.168.43.170:8080/RestServer/api/user_profile.php")
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
        //2. 部分url,需要与base_url组合
//        RestClient.builder()
//                .url("user_profile.php")
//                .loader(getContext())
//                .success(new ISuccess() {
//                    @Override
//                    public void onSuccess(String response) {
//                        Toast.makeText(Latte.getApplicationContext(),response,Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .build()
//                .get();
    }
}
