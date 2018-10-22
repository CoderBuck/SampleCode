package me.buck.samplecode.util;

import android.annotation.SuppressLint;

import java.util.Objects;

public class FileUtils {


    /**
     * 将字节数  转换为 K M G T E 具体可自己转换
     * 链接：https://stackoverflow.com/questions/3758606/how-to-convert-byte-size-into-human-readable-format-in-java
     *
     * @param bytes B
     * @param si    true 表示1000为单位  false表示 1024为单位
     */
    @SuppressLint("DefaultLocale")
    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    /**
     * 比较常规的文件大小格式
     */
    @SuppressLint("DefaultLocale")
    public static String sizeFormat(long bytes) {
        int unit = 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = "KMGTPE".charAt(exp - 1) + "";
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }
}
