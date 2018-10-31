package me.buck.samplecode.util;

import android.app.Application;

/**
 * 基本功能是保存一个 App 全局对象
 */
public class Utils {

    private static Application sApp;

    private Utils()                          {}

    public static void init(Application app) { sApp = app; }

    public static Application getApp()       { return sApp; }
}
