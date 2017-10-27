package com.northlight.latte.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.northlight.latte.delegates.LatteDelegate;
import com.northlight.latte.ec.R;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/27 15:06
 */

public class VerticalListDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    @Override
    public void onBinderView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
