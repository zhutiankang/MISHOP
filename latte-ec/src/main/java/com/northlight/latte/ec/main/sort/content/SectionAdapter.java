package com.northlight.latte.ec.main.sort.content;

import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.northlight.latte.ec.R;

import java.util.List;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/2 14:11
 */

public class SectionAdapter extends BaseSectionQuickAdapter<SectionBean,BaseViewHolder> {

    private static final RequestOptions OPTIONS = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate();

    SectionAdapter(int layoutResId, int sectionHeadResId, List<SectionBean> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, SectionBean item) {
        helper.setText(R.id.tv_header,item.header);
        helper.setVisible(R.id.tv_more,item.isMore());
        helper.addOnClickListener(R.id.tv_more);
    }

    @Override
    protected void convert(BaseViewHolder helper, SectionBean item) {
        //item.t 返回SectionContentItemEntity对象
        final SectionContentItemEntity entity = item.t;
        final String thumb = entity.getGoodsThumb();
        final String name = entity.getGoodsName();
        final int goodsId = entity.getGoodsId();

        helper.setText(R.id.tv_name,name);
        final AppCompatImageView goodsImageView = helper.getView(R.id.iv_thumb);
        Glide.with(mContext)
                .load(thumb)
                .apply(OPTIONS)
                .into(goodsImageView);

    }
}
