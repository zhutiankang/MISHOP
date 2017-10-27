package com.northlight.latte.ec.main.sort.list;

import com.northlight.latte.ui.recycler.MultipleItemEntity;
import com.northlight.latte.ui.recycler.MultipleRecyclerAdapter;

import java.util.List;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/27 16:27
 */

public class SortRecyclerAdapter extends MultipleRecyclerAdapter {

    protected SortRecyclerAdapter(List<MultipleItemEntity> data) {
        super(data);
        //添加垂直菜单布局
//        addItemType(ItemType.VERTICAL_MENU_LIST, R.layout.item_vertical_menu_list);
    }
}
