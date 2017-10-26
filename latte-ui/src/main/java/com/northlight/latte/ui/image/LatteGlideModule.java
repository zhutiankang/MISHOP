package com.northlight.latte.ui.image;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * author : 祝天康
 * tips   : v4还是以前v3的链式调用风格，不过换成GlideApp
 *          不需要RequestOptions
 * date   : 2017/10/26 08:49
 */
@GlideModule
public class LatteGlideModule extends AppGlideModule {
//                    GlideApp.with(mContext)
//                        .load(imagUrl)
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .centerCrop()
//                        .dontAnimate();
}
