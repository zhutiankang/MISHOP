package com.northlight.latte.net;

/**
 * author : tiankang
 * date : 2021/7/20 3:01 上午
 * desc :
 */
public interface NetResponse <T> {
    void onStart(String requestId);

    void onSuccess(String requestId, int code, T data, String message);

    void onError(String requestId, int code, String message);

    void onComplete(String requestId);
}
