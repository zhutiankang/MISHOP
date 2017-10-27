package com.northlight.latte.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.northlight.latte.delegates.bottom.BottomItemDelegate;
import com.northlight.latte.ec.R;
import com.northlight.latte.ec.main.sort.content.ContentListDelegate;
import com.northlight.latte.ec.main.sort.list.VerticalListDelegate;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/13 15:36
 */

public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBinderView(@Nullable Bundle savedInstanceState, View rootView) {
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListDelegate verticalListDelegate = new VerticalListDelegate();
        loadRootFragment(R.id.vertical_list_container,verticalListDelegate);
        //设置右侧第一个分类显示，默认显示分类一
        loadRootFragment(R.id.sort_content_container,ContentListDelegate.newInstance(1));
    }
}
