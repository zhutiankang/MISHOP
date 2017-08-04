package com.northlight.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.northlight.latte.delegates.LatteDelegate;
import com.northlight.latte.ec.R;
import com.northlight.latte.ec.R2;

import butterknife.BindView;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/8/3 14:56
 */

public class LauncherDelegate extends LatteDelegate{

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBinderView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
