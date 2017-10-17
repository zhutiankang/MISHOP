package com.northlight.latte.delegates.bottom;

import java.util.LinkedHashMap;

/**
 * author : 祝天康
 * tips   : 构造器，创造者，LinkedHashMap有序[key value]不然bar会乱掉
 * date   : 2017/10/13 14:39
 */

public final class ItemBuilder {
    private final LinkedHashMap<BottomTabBean,BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    /**
     * 简单工程模式
     * @return
     */
    static ItemBuilder builder(){
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(BottomTabBean bean , BottomItemDelegate delegate){
        ITEMS.put(bean,delegate);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean,BottomItemDelegate> items){
        ITEMS.putAll(items);
        return this;
    }

    public final LinkedHashMap<BottomTabBean,BottomItemDelegate> build(){
        return ITEMS;
    }
}
