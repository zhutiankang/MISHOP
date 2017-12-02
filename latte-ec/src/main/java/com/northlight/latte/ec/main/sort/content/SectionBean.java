package com.northlight.latte.ec.main.sort.content;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/2 11:21
 */

public class SectionBean extends SectionEntity<SectionContentItemEntity>{

    private boolean mIsMore = false;
    private int mId = -1;
    SectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    SectionBean(SectionContentItemEntity entity) {
        super(entity);
    }

    boolean isMore() {
        return mIsMore;
    }

    void setMore(boolean more) {
        mIsMore = more;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
