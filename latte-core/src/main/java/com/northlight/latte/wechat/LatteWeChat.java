package com.northlight.latte.wechat;

import android.app.Activity;

import com.northlight.latte.app.ConfigType;
import com.northlight.latte.app.Latte;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/11 10:31
 */

public class LatteWeChat {
    static final String APP_ID = Latte.getConfiguration(ConfigType.WE_CHAT_APP_ID);
    static final String APP_SECRET = Latte.getConfiguration(ConfigType.WE_CHAT_APP_SECRET);

    private final IWXAPI WXAPI; //wx回调接口

    private static final class Holder{
        private static final LatteWeChat INSTANCE = new LatteWeChat();
    }

    public static LatteWeChat getInstance(){
        return Holder.INSTANCE;
    }
    private LatteWeChat(){
        final Activity activity = Latte.getConfiguration(ConfigType.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity,APP_ID,true); //true 校验
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI(){
        return WXAPI;
    }

    public final void signIn(){
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }
}
