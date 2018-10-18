package me.buck.samplecode.tool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;

/**
 * 后台线程 Handler ，主要方便从主线程获取
 * Created by buck on 2018/9/14
 */

public class BgHandler {

    private HandlerThread mHandlerThread;
    private Handler mHandler;

    public BgHandler(String threadName) {
        this(threadName, null);
    }

    public BgHandler(String threadName, Handler.Callback callback) {
        mHandlerThread = new HandlerThread(threadName);
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper(),callback);
    }

    /*代理 HandlerThread 方法*/

    public boolean quit() {return mHandlerThread.quit();}

    /*代理 Handler 方法*/

    public void handleMessage(Message msg) {mHandler.handleMessage(msg);}

    public void dispatchMessage(Message msg) {mHandler.dispatchMessage(msg);}

    public String getMessageName(Message message) {return mHandler.getMessageName(message);}

    public Message obtainMessage() {return mHandler.obtainMessage();}

    public Message obtainMessage(int what) {return mHandler.obtainMessage(what);}

    public Message obtainMessage(int what, Object obj) {return mHandler.obtainMessage(what, obj);}

    public Message obtainMessage(int what, int arg1, int arg2) {return mHandler.obtainMessage(what, arg1, arg2);}

    public Message obtainMessage(int what, int arg1, int arg2, Object obj) {return mHandler.obtainMessage(what, arg1, arg2, obj);}

    public boolean post(Runnable r) {return mHandler.post(r);}

    public boolean postAtTime(Runnable r, long uptimeMillis) {return mHandler.postAtTime(r, uptimeMillis);}

    public boolean postAtTime(Runnable r, Object token, long uptimeMillis) {return mHandler.postAtTime(r, token, uptimeMillis);}

    public boolean postDelayed(Runnable r, long delayMillis) {return mHandler.postDelayed(r, delayMillis);}

    public boolean postAtFrontOfQueue(Runnable r) {return mHandler.postAtFrontOfQueue(r);}

    public void removeCallbacks(Runnable r) {mHandler.removeCallbacks(r);}

    public void removeCallbacks(Runnable r, Object token) {mHandler.removeCallbacks(r, token);}

    public boolean sendMessage(Message msg) {return mHandler.sendMessage(msg);}

    public boolean sendEmptyMessage(int what) {return mHandler.sendEmptyMessage(what);}

    public boolean sendEmptyMessageDelayed(int what, long delayMillis) {return mHandler.sendEmptyMessageDelayed(what, delayMillis);}

    public boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {return mHandler.sendEmptyMessageAtTime(what, uptimeMillis);}

    public boolean sendMessageDelayed(Message msg, long delayMillis) {return mHandler.sendMessageDelayed(msg, delayMillis);}

    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {return mHandler.sendMessageAtTime(msg, uptimeMillis);}

    public boolean sendMessageAtFrontOfQueue(Message msg) {return mHandler.sendMessageAtFrontOfQueue(msg);}

    public void removeMessages(int what) {mHandler.removeMessages(what);}

    public void removeMessages(int what, Object object) {mHandler.removeMessages(what, object);}

    public void removeCallbacksAndMessages(Object token) {mHandler.removeCallbacksAndMessages(token);}

    public boolean hasMessages(int what) {return mHandler.hasMessages(what);}

    public boolean hasMessages(int what, Object object) {return mHandler.hasMessages(what, object);}

    public Looper getLooper() {return mHandler.getLooper();}

    public void dump(Printer pw, String prefix) {mHandler.dump(pw, prefix);}
}
