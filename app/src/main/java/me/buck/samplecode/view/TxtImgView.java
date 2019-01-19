package me.buck.samplecode.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import me.buck.samplecode.R;

/**
 * Created by gwf on 2019/1/19
 */
public class TxtImgView extends FrameLayout {

    public TxtImgView(@NonNull Context context) {
        this(context,null);
    }

    public TxtImgView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setClickable(true);
        inflate(context, R.layout.txt_img,this);
    }
}
