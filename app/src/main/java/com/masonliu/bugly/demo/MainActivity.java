package com.masonliu.bugly.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.masonliu.bugly.BuglyUtil;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BuglyUtil.checkUpgrade(false);
    }

    public void checkUpgrade(View view) {
        BuglyUtil.checkUpgrade(true);
    }
}
