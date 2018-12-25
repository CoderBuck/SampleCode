package me.buck.samplecode;

import android.app.Application;

import me.buck.samplecode.util.Utils;

/**
 * Created by gwf on 2018/12/25
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
