package com.northlight.festec.example;

import com.northlight.latte.activities.ProxyActivity;
import com.northlight.latte.delegates.LatteDelegate;
import com.northlight.latte.ec.launcher.LauncherScrollDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherScrollDelegate();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Toast.makeText(Latte.getApplication(),"kkkkk",Toast.LENGTH_LONG).show();
//    }
}
