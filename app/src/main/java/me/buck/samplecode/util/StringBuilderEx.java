package me.buck.samplecode.util;

/**
 * StringBuilder 拓展
 */
public class StringBuilderEx {

    private StringBuilder sb;

    private StringBuilderEx(StringBuilder sb) {
        this.sb = sb;
    }

    public static StringBuilderEx of(StringBuilder sb) {
        return new StringBuilderEx(sb);
    }

    public StringBuilderEx append(String str) {
        sb.append(str);
        return this;
    }

    /**
     * 添加一行文字
     */
    public StringBuilderEx appendLn(String s) {
        sb.append(s).append(System.lineSeparator());
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
