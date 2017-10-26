package com.northlight.latte.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/26 10:18
 */
@AutoValue
public abstract class RgbValue {

    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbValue create(int red,int green,int blue){
        return new AutoValue_RgbValue(red, green, blue);
    }
}
