package com.northlight.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.northlight.latte.delegates.LatteDelegate;

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

    }
}
