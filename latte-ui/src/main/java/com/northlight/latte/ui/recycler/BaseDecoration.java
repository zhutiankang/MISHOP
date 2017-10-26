package com.northlight.latte.ui.recycler;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/16 10:30
 */

public class BaseDecoration extends DividerItemDecoration {

    private BaseDecoration(int color, int size) {
        setDividerLookup(new DividerLookupImp(color,size));
    }

    public static BaseDecoration create(@ColorInt int color, int size){
        return new BaseDecoration(color,size);
    }
}
