package com.northlight.festec.example.generators;

import com.northlight.latte.wechat.templates.WXEntryTemplate;
import com.northlight.latte_annotations.EntryGenerator;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/9/29 15:45
 */
@EntryGenerator(
        packageName = "com.northlight.festec.example",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
