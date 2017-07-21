package com.northlight.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * author : 祝天康
 * tips   : 工具类
 * date   : 2017/7/21 08:36
 */

public final class Latte {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }
}
