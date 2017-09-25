package com.northlight.latte.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.northlight.latte.app.AccoutManager;
import com.northlight.latte.app.IUserChecker;
import com.northlight.latte.delegates.LatteDelegate;
import com.northlight.latte.ec.R;
import com.northlight.latte.ec.R2;
import com.northlight.latte.ui.launcher.ILauncherListener;
import com.northlight.latte.ui.launcher.OnLauncherFinishTag;
import com.northlight.latte.ui.launcher.ScrollLauncherTag;
import com.northlight.latte.util.storage.LattePreference;
import com.northlight.latte.util.timer.BaseTimerTask;
import com.northlight.latte.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author : 祝天康
 * tips   : 启动页
 * date   : 2017/8/3 14:56
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    private Timer mTimer = null;
    private int mCount = 5;
    private ILauncherListener mLauncherListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener){
            mLauncherListener = (ILauncherListener)activity;
        }
    }

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBinderView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    //判断是否显示滑动启动页
    private void checkIsShowScroll(){
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())){
            startWithPop(new LauncherScrollDelegate());
        }else {
            //检查用户是否已经登录
            AccoutManager.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    if (mLauncherListener != null){
                        mLauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                    }
                }

                @Override
                public void onNotSignIn() {
                    if (mLauncherListener != null){
                        mLauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });
        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format(getString(R.string.launcher_jump)+"\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScroll();
                        }
                    }
                }
            }
        });
    }
}
