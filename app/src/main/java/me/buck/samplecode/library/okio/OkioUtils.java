package me.buck.samplecode.library.okio;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

import java.io.InputStream;
import java.io.OutputStream;

public class OkioUtils {

    public static BufferedSource buffer(InputStream inputStream) {
        return Okio.buffer(Okio.source(inputStream));
    }

    public static BufferedSink buffer(OutputStream outputStream) {
        return Okio.buffer(Okio.sink(outputStream));
    }
}
