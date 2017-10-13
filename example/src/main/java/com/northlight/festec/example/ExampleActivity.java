package com.northlight.festec.example;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.northlight.latte.activities.ProxyActivity;
import com.northlight.latte.app.Latte;
import com.northlight.latte.delegates.LatteDelegate;
import com.northlight.latte.ec.main.EcBottomDelegate;
import com.northlight.latte.ec.sign.ISignListener;
import com.northlight.latte.ec.sign.SignInDelegate;
import com.northlight.latte.ui.launcher.ILauncherListener;
import com.northlight.latte.ui.launcher.OnLauncherFinishTag;

public class ExampleActivity extends ProxyActivity implements
        ISignListener,
        ILauncherListener{

    @Override
    public LatteDelegate setRootDelegate() {
        return new EcBottomDelegate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if ((actionBar != null)){
            actionBar.hide();
        }
        Latte.getConfigurator().withActivity(this);
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag){
            case SIGNED:
                Toast.makeText(this,"启动结束，用户已登录",Toast.LENGTH_SHORT).show();
                startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this,"启动结束，用户没登录",Toast.LENGTH_SHORT).show();
                //start的同时把栈中上一个彻底清除掉，(不会回退到该界面)启动图用一次就行了，不需要存在栈中
                //单任务栈有清除和复用的作用，比pop作用大
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
