package com.northlight.festec.example;


import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.northlight.latte.activities.ProxyActivity;
import com.northlight.latte.delegates.LatteDelegate;
import com.northlight.latte.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new SignUpDelegate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if ((actionBar != null)){
            actionBar.hide();
        }
    }
}
