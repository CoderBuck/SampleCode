package me.buck.samplecode.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import me.buck.samplecode.R;

/**
 * 延迟响应的按钮
 * Created by gwf on 2019/1/30
 */
public class MyBtn extends android.support.v7.widget.AppCompatImageView implements View.OnClickListener {
    private static final String TAG = "MyBtn";

    public MyBtn(Context context) {
        super(context);
    }

    public MyBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClickable(true);

        setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //setPressed(true);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAccent)));

        postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "run: ===========");

            }
        }, 1000);

        postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "run: ===========");
                //setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                setBackgroundResource(R.drawable.selector_btn);
                //setPressed(false);
            }
        }, 1100);
    }
}
