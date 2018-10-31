package me.buck.samplecode.util;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;


/**
 * 广播工具类,主要用作发送广播
 * 实际业务里要发送的广播都在这里添加，方便管理
 * Created by Buck on 2018/1/20
 */

public class BroadcastUtils {

    public static void sendLocal(Intent intent)  { LocalBroadcastManager.getInstance(Utils.getApp()).sendBroadcast(intent); }

    public static void sendGlobal(Intent intent) { Utils.getApp().sendBroadcast(intent); }

}
