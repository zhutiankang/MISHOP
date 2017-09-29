package com.northlight.festec.example.generators;

import com.northlight.latte.wechat.templates.WXPayEntryTemplate;
import com.northlight.latte_annotations.PayEntryGenerator;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/9/29 15:45
 */
@PayEntryGenerator(
        packageName = "com.northlight.festec.example",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
