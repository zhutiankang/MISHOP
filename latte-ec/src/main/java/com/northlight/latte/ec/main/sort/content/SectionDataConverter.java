package com.northlight.latte.ec.main.sort.content;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/2 11:20
 */

class SectionDataConverter {


    private final ArrayList<SectionBean> ENTITIES = new ArrayList<>();
    private String mJsonData = null;

    ArrayList<SectionBean> convert(){
        final JSONArray dataArray = JSON
                .parseObject(getJsonData())
                .getJSONArray("data");
        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);

            final int id = data.getInteger("id");
            final String title = data.getString("section");

            //添加title
            final SectionBean sectionTitleBean = new SectionBean(true,title);
            sectionTitleBean.setId(id);
            sectionTitleBean.setMore(true);
            ENTITIES.add(sectionTitleBean);

            final JSONArray goods = data.getJSONArray("goods");
            //商品内容循环
            final int goodSize = goods.size();
            for (int j = 0; j < goodSize; j++) {
                final JSONObject contentItem = goods.getJSONObject(j);
                final int goodsId = contentItem.getInteger("goods_id");
                final String goodsName = contentItem.getString("goods_name");
                final String goodsThumb = contentItem.getString("goods_thumb");
                //获取内容
                final SectionContentItemEntity itemEntity = new SectionContentItemEntity();
                itemEntity.setGoodsId(goodsId);
                itemEntity.setGoodsName(goodsName);
                itemEntity.setGoodsThumb(goodsThumb);
                //添加内容
                ENTITIES.add(new SectionBean(itemEntity));
            }
            //商品内容循环结束
        }
        //Section循环结束
        return ENTITIES;
    }




    SectionDataConverter setJsonData(String json){
        this.mJsonData = json;
        return this;
    }

    private String getJsonData() {
        if (mJsonData == null || mJsonData.isEmpty()){
            throw new NullPointerException("DATA IS NULL!");
        }
        return mJsonData;
    }
}
