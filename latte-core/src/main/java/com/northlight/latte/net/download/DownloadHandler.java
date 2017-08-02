package com.northlight.latte.net.download;

import android.os.AsyncTask;

import com.northlight.latte.net.RestCreator;
import com.northlight.latte.net.callback.IError;
import com.northlight.latte.net.callback.IFailure;
import com.northlight.latte.net.callback.IRequest;
import com.northlight.latte.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/8/2 14:28
 */

public class DownloadHandler {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;

    public DownloadHandler(String url,
                           IRequest request,
                           String downloadDir,
                           String extension,
                           String name,
                           ISuccess success,
                           IFailure failure,
                           IError error) {
        this.URL = url;
        this.REQUEST = request;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
    }

    public final void handleDownload(){
        if (REQUEST != null){
            REQUEST.onRequestStart();
        }
        RestCreator.getRestService().download(URL,PARAMS).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    if (call.isExecuted()){
                        final ResponseBody responseBody = response.body();
                        final SaveFileTask task = new SaveFileTask(REQUEST,SUCCESS);
                        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,DOWNLOAD_DIR,EXTENSION,NAME,responseBody);

                        //这里一定要注意判断，否则文件下载不全
                        if (task.isCancelled()){
                            if (REQUEST != null){
                                REQUEST.onRequestEnd();
                            }
                        }
                    }
                }else {
                    if (ERROR != null){
                        ERROR.onError(response.code(),response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (FAILURE != null){
                    FAILURE.onFailure();
                }
            }
        });
    }
}
