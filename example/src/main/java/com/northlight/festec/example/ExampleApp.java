package com.northlight.festec.example;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.northlight.latte.app.Latte;

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
                .withApiHost("http://127.0.0.1/")
                .configure();

        Iconify.with(new FontAwesomeModule())
                .with(new IoniconsModule());
    }
}
