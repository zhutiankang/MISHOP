package com.northlight.latte.net;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * author : tiankang
 * date : 2021/7/20 3:00 上午
 * desc : 没卵用
 */
public class CancelRequest {
    public static final ConcurrentHashMap<String, Disposable> disposableMap = new ConcurrentHashMap();
    public static final ConcurrentHashMap<String, NetResponse> netResponseMap = new ConcurrentHashMap();

    public static final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public final void remove(@NotNull String requestId, @NotNull Disposable disposable, @Nullable NetResponse netResponse) {

        if (requestId.length() != 0) {
            if (disposableMap.containsKey(requestId)) {
                if (disposableMap.get(requestId)!= null) {
                    compositeDisposable.remove(disposableMap.get(requestId));
                }

                NetResponse netResponse1 = CancelRequest.netResponseMap.remove(requestId);
                if (netResponse1 != null) {
                    netResponse1.onError(requestId, -1004, "请求取消");
                    netResponse1.onComplete(requestId);
                }
            }

            compositeDisposable.add(disposable);
            disposableMap.put(requestId, disposable);
            if (netResponse != null) {
                netResponseMap.put(requestId, netResponse);
            }

        }
    }
}
