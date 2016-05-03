package com.masonliu.bugly;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.beta.Beta;

/**
 * Created by liumeng on 16/5/3.
 */
public class BuglyUtil {
    public static void init(Context context, String buglyAppid, String channel) {
        BuglyStrategy strategy = null;
        if (!TextUtils.isEmpty(channel)) {
            strategy = new BuglyStrategy();
            strategy.setAppChannel(channel);
        }
        Beta.autoCheckUpgrade = false;
        //默认延迟两秒
        Beta.initDelay = 2000;
        Bugly.init(context.getApplicationContext(), buglyAppid, false, strategy);
    }

    public static void checkUpgrade() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Beta.checkUpgrade(false, false);
            }
        }, 4000);
    }
}
