package com.northlight.latte.ec.main.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.northlight.latte.delegates.bottom.BottomItemDelegate;
import com.northlight.latte.ec.R;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/13 15:37
 */

public class DiscoverDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_discover;
    }

    @Override
    public void onBinderView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
