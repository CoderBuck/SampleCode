package me.buck.samplecode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.buck.samplecode.library.gson.GsonUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = "{\"type\" : 0 }";

        A a = GsonUtils.fromJson(json, A.class);
        Log.d(TAG, "onCreate: " + GsonUtils.toJson(a));

    }

}
