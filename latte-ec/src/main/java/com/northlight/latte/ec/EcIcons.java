package com.northlight.latte.ec;

import com.joanzapata.iconify.Icon;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/7/25 15:45
 */

public enum EcIcons implements Icon {
    icon_scan('\ue602'),
    icon_ali_pay('\ue606');

    char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return this.name().replace('_', '-');
    }

    @Override
    public char character() {
        return this.character;
    }

}
