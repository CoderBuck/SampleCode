package me.buck.samplecode.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 方便把 Closeable 对象写在try块外面
 *
 * <pre> {@code
 * try (TryWith close = TryWith.io(closeable1, closeable2)) {
 *      System.out.println("TryWith");
 * }</pre>
 */
public class TryWith implements Closeable {

    private List<Closeable> mCloseables;

    public TryWith(List<Closeable> closeables) {
        mCloseables = closeables;
    }

    @Override
    public void close() throws IOException {
        for (Closeable closeable : mCloseables) {
            if (closeable != null) {
                closeable.close();
            }
        }
    }

    public static TryWith io(Closeable... autoCloseables) {
        List<Closeable> closeables = Arrays.asList(autoCloseables);
        return new TryWith(closeables);
    }
}
