package com.northlight.latte.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.northlight.latte.activities.ProxyActivity;
import com.northlight.latte.net.NetResponse;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import kotlin.jvm.internal.Intrinsics;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/7/26 14:02
 */

public abstract class BaseDelegate extends SwipeBackFragment {

    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUnbinder = null;

    protected BaseDelegate() {
        this.netGroup = "" + '[' + this.hashCode() + ']';
    }

    public abstract Object setLayout();

    public abstract void onBinderView(@Nullable Bundle savedInstanceState,View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView;
        if (setLayout() instanceof Integer){
            rootView = inflater.inflate((Integer) setLayout(),container,false);
        }else if (setLayout() instanceof View){
            rootView = (View) setLayout();
        }else {
            throw new ClassCastException("setLayout() type must be int or View!");
        }
        mUnbinder = ButterKnife.bind(this,rootView);
        onBinderView(savedInstanceState,rootView);

        return rootView;
    }

    public final ProxyActivity getProxyActivity(){
        return (ProxyActivity) _mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
    }

    public String getNetGroup() {
        return netGroup;
    }

    private final String netGroup;


    @Override
    public void onStop() {
        super.onStop();
        //cancelRequest
    }

    public final String a() {
        String var10000 = UUID.randomUUID().toString();
        return var10000;
    }

    public final void cancelAllRequest() {
        f var10000 = f.d;
        Iterator var2 = f.b.entrySet().iterator();

        while(var2.hasNext()) {
            Map.Entry var3 = (Map.Entry)var2.next();
            String var1 = (String)var3.getKey();
            NetResponse var4 = (NetResponse)var3.getValue();
            var4.onError(var1, -1004, "请求取消");
            var4.onComplete(var1);
        }

        f.c.clear();
        f.a.clear();
        f.b.clear();
    }

    public final boolean hasRequest(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, "requestId");
        b var3;
        (var3 = this.realCall).getClass();
        Intrinsics.checkNotNullParameter(var1, "requestId");
        boolean var4;
        if (var1.length() != 0) {
            f var10001 = f.d;
            Intrinsics.checkNotNullParameter(var1, "key");
            if (f.a.containsKey(var1) || var3.b.containsKey(var1)) {
                var4 = true;
                return var4;
            }
        }

        var4 = false;
        return var4;
    }
}
