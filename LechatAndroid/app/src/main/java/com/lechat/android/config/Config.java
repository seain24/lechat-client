package com.lechat.android.config;

import android.annotation.SuppressLint;

public final class Config {
    public static final String APP_ID = "315721057f";
    // 存储地址
    @SuppressLint("SdCardPath")
    public static String DEFAULT_APP_PATH = "/sdcard/lechat";
    @SuppressLint("SdCardPath")
    public static String DEFAULT_USERS_PATH = "/sdcard/lechat/Users";
    @SuppressLint("SdCardPath")
    public static String DEFAULT_LOG_PATH = "/sdcard/lechat/Logs";

    // 服务端地址
    public static String CHAT_SERVER_IP = "120.55.94.78";
    public static short CHAT_SERVER_PORT = 20000;
    public static String IMG_SERVER_IP = "120.55.94.78";
    public static short IMG_SERVER_PORT = 20001;
    public static String FILE_SERVER_IP = "120.55.94.78";
    public static short FILE_SERVER_PORT = 20002;

    public static int CHAT_NOTIFICATION_ID = 0;
}
