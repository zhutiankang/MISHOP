package com.northlight.latte.ui.recycler;

import com.choices.divider.Divider;
import com.choices.divider.DividerItemDecoration;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/26 09:13
 */

public class DividerLookupImp implements DividerItemDecoration.DividerLookup{

    private final int COLOR;
    private final int SIZE;

    public DividerLookupImp(int color, int size) {
        this.COLOR = color;
        this.SIZE = size;
    }

    @Override
    public Divider getVerticalDivider(int position) {
        return new Divider.Builder()
                .size(SIZE)
                .color(COLOR)
                .build();
    }

    @Override
    public Divider getHorizontalDivider(int position) {
        return new Divider.Builder()
                .size(SIZE)
                .color(COLOR)
                .build();
    }
}
