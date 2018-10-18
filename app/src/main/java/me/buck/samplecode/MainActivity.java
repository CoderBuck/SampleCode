package me.buck.samplecode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.buck.samplecode.test.SeekBarActivity;
import me.buck.samplecode.tool.SimpleCountDownTimer;
import me.buck.samplecode.tool.TimingLogger;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, SeekBarActivity.class));
    }

}
