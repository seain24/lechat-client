package com.lechat.android;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * @Author: Seain
 * @Date: on 2024-10-20 17:13.
 * @Description: 应用程序Activity管理类：用于Activity管理和应用程序退出
 */
public class AppManager {
    private Stack<Activity> activityStack;

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public synchronized Activity currentActivity() {
        if (activityStack.empty()) {
            return null;
        }
        return activityStack.lastElement();
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        if (activityStack.empty()) {
            return;
        }

        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (Activity act : activityStack) {
            if (act != null) {
                act.finish();
            }
        }

        activityStack.clear();
    }

    /**
     * 结束所有的activity，但保留指定的某个activity
     */
    public void finishAllActivity(Activity keeped) {
        for (Activity act : activityStack) {
            if (act != null && act != keeped) {
                act.finish();
            }
        }

        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }
}
