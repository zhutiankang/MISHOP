package com.northlight.latte.net.rx;

import android.content.Context;

import com.northlight.latte.net.RestCreator;
import com.northlight.latte.ui.loader.LoaderStyle;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/7/28 15:01
 */

public class RxRestClientBuilder {

    private String mUrl = null;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private RequestBody mBody = null;
    private File mFile = null;
    private LoaderStyle mLoaderStyle = null;
    private Context mContext = null;


    RxRestClientBuilder(){
    }

    public final RxRestClientBuilder url(String url){
        mUrl = url;
        return this;
    }

    public final RxRestClientBuilder params(WeakHashMap<String, Object> params){
        PARAMS.putAll(params);
        return this;
    }

    public final RxRestClientBuilder params(String key, Object value){
        PARAMS.put(key,value);
        return this;
    }
    public final RxRestClientBuilder file(File file){
        mFile = file;
        return this;
    }
    public final RxRestClientBuilder file(String file){
        mFile = new File(file);
        return this;
    }
    //原始数据字符串
    public final RxRestClientBuilder raw(String raw){
        mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }

    public final RxRestClientBuilder loader(Context context, LoaderStyle loaderStyle){
        mLoaderStyle = loaderStyle;
        mContext = context;
        return this;
    }

    public final RxRestClientBuilder loader(Context context){
        mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        mContext = context;
        return this;
    }

    public final RxRestClient build(){
        return new RxRestClient(mUrl,
                PARAMS,
                mBody,
                mFile,
                mLoaderStyle,
                mContext);
    }
}
