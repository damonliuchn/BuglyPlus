package com.masonliu.bugly.demo;

import android.app.Application;

import com.masonliu.bugly.BuglyUtil;

/**
 * Created by liumeng on 16/5/3.
 */
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        BuglyUtil.init(this, "900028213", null);
    }
}
