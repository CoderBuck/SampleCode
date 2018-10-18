package me.buck.samplecode.util;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;


/**
 * 广播工具类
 * Created by Buck on 2018/1/20
 */

public class BroadcastUtils {

    private BroadcastUtils() {
    }

    /**
     * send
     */
    public static void sendLocal(Intent intent) {
        getLocalManager().sendBroadcast(intent);
    }

    public static void sendLocal(String action) {
        Intent intent = new Intent(action);
        sendLocal(intent);
    }

    public static void sendGlobal(Intent intent) {
        Utils.getApp().sendBroadcast(intent);
    }

    public static void sendGlobal(String action) {
        Intent intent = new Intent(action);
        sendGlobal(intent);
    }

    //======== /*register*/ ========

    public static void registerGlobal(BroadcastReceiver receiver, IntentFilter filter) {
        Utils.getApp().registerReceiver(receiver, filter);
    }

    public static void registerGlobal(BroadcastReceiver receiver, String... actions) {
        IntentFilter filter = new IntentFilter();
        for (String action : actions) {
            filter.addAction(action);
        }
        registerGlobal(receiver,filter);
    }

    public static void registerLocal(BroadcastReceiver receiver, IntentFilter filter) {
        getLocalManager().registerReceiver(receiver, filter);
    }

    public static void registerLocal(BroadcastReceiver receiver, String... actions) {
        IntentFilter filter = new IntentFilter();
        for (String action : actions) {
            filter.addAction(action);
        }
        registerLocal(receiver,filter);
    }

    //======== /*unregister*/ ========

    public static void unregisterLocal(BroadcastReceiver receiver) {
        getLocalManager().unregisterReceiver(receiver);
    }

    public static void unregisterGlobal(BroadcastReceiver receiver) {
        Utils.getApp().unregisterReceiver(receiver);
    }

    private static LocalBroadcastManager getLocalManager() {
        return LocalBroadcastManager.getInstance(Utils.getApp());
    }

}
