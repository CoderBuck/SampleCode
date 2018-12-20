package me.buck.samplecode.tool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * 广播接收器的简单封装，默认接收本地广播
 */
public abstract class SimpleReceiver extends BroadcastReceiver {

    protected Context      mContext;
    protected boolean      mIsLocal;
    protected IntentFilter mFilter;

    public SimpleReceiver(Context context) {
        this(context, true);
    }

    public SimpleReceiver(Context context, boolean local) {
        mContext = context;
        mIsLocal = local;
        mFilter = new IntentFilter();
    }

    public void register() {
        if (mIsLocal) {
            LocalBroadcastManager.getInstance(mContext).registerReceiver(this, mFilter);
        } else {
            mContext.registerReceiver(this, mFilter);
        }
    }

    public void unregister() {
        try {
            if (mIsLocal) {
                LocalBroadcastManager.getInstance(mContext).unregisterReceiver(this);
            } else {
                mContext.unregisterReceiver(this);
            }
        } catch (IllegalArgumentException e) {
            // 有时候会抛出没有注册的异常，在 activity 的 onCreate 和 onDestroy 注册和取消注册时，快速创建销毁activity会出现此异常
            e.printStackTrace();
            Log.e("SimpleReceiver", "unregister: " + e.getMessage());
        }
    }
}