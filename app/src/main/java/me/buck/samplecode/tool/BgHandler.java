package me.buck.samplecode.tool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/**
 * 后台线程 Handler ，主要方便从主线程获取
 * Created by buck on 2018/9/14
 */

public class BgHandler extends Handler {

    private static Looper getLooper(String threadName) {
        HandlerThread holder = new HandlerThread(threadName);
        holder.start();
        return holder.getLooper();
    }

    public BgHandler(String threadName) {
        this(threadName, null);
    }

    public BgHandler(String threadName, Callback callback) {
        super(getLooper(threadName), callback);
    }

    public void quit() {
        getLooper().quit();
    }

}
