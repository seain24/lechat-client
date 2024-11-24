package com.lechat.android;

import static com.lechat.android.config.Config.*;

import android.app.Application;
import android.content.Context;

import com.lechat.android.pojo.MemberEntity;
import com.lechat.android.utils.LoggerFile;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.File;

/**
 * 应用程序类
 */

public class LeChatApplication extends Application {
    private static final String TAG = "LeChatApplication";
    public static LeChatApplication instance;
    private AppManager appManager;

//    private DbUtils db;
//    private AppManager appManager;
//    private TabbarEnum tabIndex = TabbarEnum.FRIEND;

    //屏幕宽
    private int screenWidth;
    //屏幕高
    private int screenHeight;

    private boolean running = false;

    //用户信息
    private MemberEntity memberEntity;
//    private UserServer userServer;

//    private DaoSession mDaoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        CrashReport.initCrashReport(getApplicationContext(), APP_ID, true);

        //创建根目录
        File appDir = new File(DEFAULT_APP_PATH);
        if (!appDir.exists()) {
            appDir.mkdir();
        }

        //创建Users目录
        File usersDir = new File(DEFAULT_USERS_PATH);
        if (!usersDir.exists()) {
            usersDir.mkdir();
        }

        //创建Logs目录
        File logsDir = new File(DEFAULT_LOG_PATH);
        if (!logsDir.exists()) {
            logsDir.mkdir();
        }

        LoggerFile.Init(true);
        LoggerFile.LogInfo("FlamingApplication initialization completed");
    }

    public static LeChatApplication getInstance() {
        return instance;
    }


    public AppManager getAppManager() {
        if (appManager == null) {
            appManager = new AppManager();
        }
        return appManager;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public MemberEntity getMemberEntity() {
        if (memberEntity == null) {
            memberEntity = new MemberEntity();
        }
        return memberEntity;
    }
}
