package me.buck.samplecode.Util;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.DisplayMetrics;

/**
 * 获取 Resources 资源
 * <p>
 * Created by Buck on 2018/4/13
 */
public class ResUtils {

    private ResUtils() {
    }

    public static Resources getResources() {
        return Utils.getApp().getResources();
    }

    @NonNull
    public static String getString(@StringRes int id) {
        return getResources().getString(id);
    }

    @NonNull
    public static String getString(@StringRes int id, Object... formatArgs) {
        return getResources().getString(id, formatArgs);
    }

    public static int getColor(@ColorRes int id) {
        return getResources().getColor(id);
    }

    public static float getDimension(@DimenRes int id) {
        return getResources().getDimension(id);
    }

    public static Drawable getDrawable(@DrawableRes int id) {
        return getResources().getDrawable(id);
    }

    public static Configuration getConfiguration() {
        return getResources().getConfiguration();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public static int getDisplayHeight() {
        return getDisplayMetrics().heightPixels;
    }

    public static int getDisplayWidth() {
        return getDisplayMetrics().widthPixels;
    }

}
