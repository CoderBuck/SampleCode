package me.buck.samplecode.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import me.buck.samplecode.R;

/**
 * 一个图片一个文字的按钮
 * 图片和文字 id 必须为 img 和 txt
 * Created by gwf on 2019/1/19
 */
public abstract class TxtImgView2 extends FrameLayout {

    protected ImageView mImageView;
    protected TextView mTextView;

    protected Drawable mDrawable;
    protected String mTxt;

    public TxtImgView2(@NonNull Context context) {
        this(context,null);
    }

    public TxtImgView2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setClickable(true);
        setFocusable(true);
        inflate(context, layoutId(),this);
        mImageView = findViewById(R.id.img);
        mTextView = findViewById(R.id.txt);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TxtImgView2);
        mTxt = typedArray.getString(R.styleable.TxtImgView2_ti_txt);
        mDrawable = typedArray.getDrawable(R.styleable.TxtImgView2_ti_img);
        typedArray.recycle();

        mImageView.setImageDrawable(mDrawable);
        mTextView.setText(mTxt);
    }

    abstract int layoutId();






}
