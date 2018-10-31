package me.buck.samplecode.tool;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;

/**
 * UI 线程 Handler，主要方便从后台线程获取
 * Created by buck on 2018/9/14
 */

public class UiHandler extends Handler{

    public UiHandler() {
        this(null);
    }

    public UiHandler(Callback callback) {
        super(Looper.getMainLooper(),callback);
    }

    public void removeAll() {
        removeCallbacksAndMessages(null);
    }

}
