package com.northlight.latte.app;

import com.northlight.latte.util.storage.LattePreference;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/9/25 09:44
 */

public class AccoutManager {

    private enum SignTag{
        SIGN_TAG
    }
    //保存用户登录状态，登录后调用
    public static void setSignState(boolean state){
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(),state);
    }
    public static boolean isSignIn(){
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker){
        if (isSignIn()){
            checker.onSignIn();
        }else {
            checker.onNotSignIn();
        }
    }
}
