package com.lechat.android.broadcaster

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log

/**
 * @Author: Seain
 * @Date: on 2024-10-20 23:53.
 * @Description: 用于实时监听app的网络状态
 */
class NetBroadcastReceiver: BroadcastReceiver() {
    private val TAG = "NetworkBroadcaster"
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG, "onReceive: network status changed")
        val manager = context?.getSystemService(ConnectivityManager::class.java)
        manager?.regi

    }
}