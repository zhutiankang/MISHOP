package com.northlight.latte.delegates;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/7/26 16:26
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate {


    @SuppressWarnings("unchecked")
    public <T extends LatteDelegate> T getParentDelegate(){
        return (T) getParentFragment();
    }
}
