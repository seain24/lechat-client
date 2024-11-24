package com.lechat.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;

/**
 * @Author: Seain
 * @Date: on 2024-10-20 23:25.
 * @Description: 网络工具类
 */
public final class NetworkUtil {

    /**
     * 判断网络是否连接
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
        if (manager == null) {
            return false;
        }

        Network currentNetwork = manager.getActiveNetwork();
        NetworkCapabilities caps = manager.getNetworkCapabilities(currentNetwork);
        LinkProperties linkProps = manager.getLinkProperties(currentNetwork);


    }
}
