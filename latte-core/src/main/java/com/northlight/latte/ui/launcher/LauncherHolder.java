package com.northlight.latte.ui.launcher;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/8/5 10:49
 */

public class LauncherHolder implements Holder<Integer> {
    private AppCompatImageView mImageView = null;
    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        mImageView.setBackgroundResource(data);//不设置src设置background方便占据整个屏幕
    }
}
