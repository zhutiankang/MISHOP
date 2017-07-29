package com.northlight.latte.net;

import android.content.Context;

import com.northlight.latte.net.callback.IError;
import com.northlight.latte.net.callback.IFailure;
import com.northlight.latte.net.callback.IRequest;
import com.northlight.latte.net.callback.ISuccess;
import com.northlight.latte.ui.LoaderStyle;

import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/7/28 15:01
 */

public class RestClientBuilder {

    private String mUrl = null;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mRequest = null;
    private ISuccess mSuccess = null;
    private IFailure mFailure = null;
    private IError mError = null;
    private RequestBody mBody = null;
    private LoaderStyle mLoaderStyle = null;
    private Context mContext = null;

    RestClientBuilder(){
    }

    public final RestClientBuilder url(String url){
        mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params){
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key,Object value){
        PARAMS.put(key,value);
        return this;
    }

    //原始数据字符串
    public final RestClientBuilder raw(String raw){
        mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }
    public final RestClientBuilder onRequest(IRequest iRequest){
        mRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess){
        mSuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure){
        mFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError){
        mError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context,LoaderStyle loaderStyle){
        mLoaderStyle = loaderStyle;
        mContext = context;
        return this;
    }

    public final RestClientBuilder loader(Context context){
        mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        mContext = context;
        return this;
    }

    public final RestClient build(){
        return new RestClient(mUrl,PARAMS,mRequest,mSuccess,mFailure,mError,mBody,mLoaderStyle,mContext);
    }
}
