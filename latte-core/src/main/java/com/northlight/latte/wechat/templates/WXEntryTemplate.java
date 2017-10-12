package com.northlight.latte.wechat.templates;

import com.northlight.latte.wechat.BaseWXEntryActivity;
import com.northlight.latte.wechat.LatteWeChat;

/**
 * author : 祝天康
 * tips   : 设置成透明 登录完成之后finish掉
 * date   : 2017/9/29 15:40
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0,0);//不需要有任何动画效果
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
