package com.northlight.festec.example.generators;

import com.northlight.latte.wechat.templates.AppRegisterTemplate;
import com.northlight.latte_annotations.AppRegisterGenerator;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/9/29 15:45
 */
@AppRegisterGenerator(
        packageName = "com.northlight.festec.example",
        registerTemplete = AppRegisterTemplate.class
)
public interface AppRegister {
}
