package com.northlight.festec.example;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.northlight.latte.app.Latte;
import com.northlight.latte.ec.database.DatabaseManager;
import com.northlight.latte.ec.icon.FontEcModule;
import com.northlight.latte.net.interceptors.DebugInterceptor;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/7/21 10:57
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new IoniconsModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://www.xiufm.com//RestServer/api/")
                .withInterceptor(new DebugInterceptor("test",R.raw.test))
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .configure();
        DatabaseManager.getInstance().init(this);
        initStetho();
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
