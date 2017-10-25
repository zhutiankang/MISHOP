package com.northlight.latte.ui.banner;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/25 10:51
 */

public class ImageHolder implements Holder<String> {
    private AppCompatImageView mImageView = null;
    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        final RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .centerCrop();

        Glide.with(context)
                .load(data)
                .apply(options)
                .into(mImageView);
    }
}
