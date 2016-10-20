package com.masonliu.bugly;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.beta.Beta;

import java.lang.reflect.Field;

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
        //默认延迟两秒启动buglySDK
        Beta.initDelay = 2000;
        Bugly.init(context.getApplicationContext(), buglyAppid, false, strategy);//第三个参数指是否打印日志
    }

    public static void checkUpgrade(final boolean isManual) {
        if (!hasInit()) {
            Log.e("BuglyUtil", "BuglyUtil should be init first.");
            return;
        }
        if (isManual) {
            /**
             * @param isManual 用户手动点击检查,非用户点击操作请传false
             * @param isSilence 是否显示弹窗等交互,[true:没有弹窗和toast] [false:有弹窗或toast]
             */
            Beta.checkUpgrade(isManual, false);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Beta.checkUpgrade(isManual, false);
                }
            }, 4000);//延迟4秒检测更新,直接检查更新是不行的.
        }
    }

    /**
     * reflect得到Bugly是否已经被初始化
     *
     * @return true已初始化 ,false未初始化
     */
    private static boolean hasInit() {
        try {
            Class clazz = Bugly.class;
            Field hasInitField = clazz.getDeclaredField("a");
            hasInitField.setAccessible(true);
            return hasInitField.getBoolean(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }
}
