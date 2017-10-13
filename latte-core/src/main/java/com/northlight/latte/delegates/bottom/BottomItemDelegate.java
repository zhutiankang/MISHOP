package com.northlight.latte.delegates.bottom;

import android.widget.Toast;

import com.northlight.latte.R;
import com.northlight.latte.app.Latte;
import com.northlight.latte.delegates.LatteDelegate;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/13 14:32
 */

public abstract class BottomItemDelegate extends LatteDelegate{

    //再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME){
            _mActivity.finish();
        }else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "双击退出" + Latte.getApplicationContext().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
