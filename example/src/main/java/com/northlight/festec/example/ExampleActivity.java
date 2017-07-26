package com.northlight.festec.example;

import com.northlight.latte.activities.ProxyActivity;
import com.northlight.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Toast.makeText(Latte.getApplication(),"kkkkk",Toast.LENGTH_LONG).show();
//    }
}
