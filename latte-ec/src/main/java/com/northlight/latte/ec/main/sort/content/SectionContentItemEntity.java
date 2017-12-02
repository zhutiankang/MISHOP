package com.northlight.latte.ec.main.sort.content;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/2 11:21
 */

class SectionContentItemEntity {

    private int goodsId = 0;
    private String goodsName = null;
    private String goodsThumb = null;


    int getGoodsId() {
        return goodsId;
    }

    void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    String getGoodsName() {
        return goodsName;
    }

    void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    String getGoodsThumb() {
        return goodsThumb;
    }

    void setGoodsThumb(String goodsThumb) {
        this.goodsThumb = goodsThumb;
    }
}
