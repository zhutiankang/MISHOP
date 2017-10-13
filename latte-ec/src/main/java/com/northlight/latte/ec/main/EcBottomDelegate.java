package com.northlight.latte.ec.main;

import android.graphics.Color;

import com.northlight.latte.delegates.bottom.BaseBottomDelegate;
import com.northlight.latte.delegates.bottom.BottomItemDelegate;
import com.northlight.latte.delegates.bottom.BottomTabBean;
import com.northlight.latte.delegates.bottom.ItemBuilder;
import com.northlight.latte.ec.main.cart.ShopCartDelegate;
import com.northlight.latte.ec.main.discover.DiscoverDelegate;
import com.northlight.latte.ec.main.index.IndexDelegate;
import com.northlight.latte.ec.main.personal.PersonalDelegate;
import com.northlight.latte.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/13 15:33
 */

public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}","分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}","发现"),new DiscoverDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}","购物车"),new ShopCartDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new PersonalDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
