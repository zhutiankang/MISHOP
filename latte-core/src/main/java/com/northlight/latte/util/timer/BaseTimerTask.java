package com.northlight.latte.util.timer;

import java.util.TimerTask;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/8/3 15:43
 */

public class BaseTimerTask extends TimerTask {
    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener ITimerListener) {
        mITimerListener = ITimerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null){
            mITimerListener.onTimer();
        }
    }
}
