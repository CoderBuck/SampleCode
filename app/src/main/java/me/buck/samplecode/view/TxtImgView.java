package me.buck.samplecode.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import me.buck.samplecode.R;


/**
 * 包含一个图片和一行文字的布局
 * 只有设置文字和图片的两个属性，具体的对齐操作可以继承后实现，写太多的自定义属性麻烦
 * Created by gwf on 2018/12/18
 */
public class TxtImgView extends FrameLayout {
    private static final String TAG = "TxtImgView";

    protected TextView  mTextView;
    protected ImageView mImageView;

    protected String   mTxt;
    protected Drawable mDrawable;

    protected LayoutParams mImgParams;
    protected LayoutParams mTxtParams;

    public TxtImgView(@NonNull Context context) {
        this(context, null);
    }

    public TxtImgView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TxtImgView);
        mTxt = typedArray.getString(R.styleable.TxtImgView_ti_txt);
        mDrawable = typedArray.getDrawable(R.styleable.TxtImgView_ti_img);
        typedArray.recycle();
        mTextView = new TextView(context);
        mImageView = new ImageView(context);
        initTextView();
        initImageView();
        mTextView.setText(mTxt);
        mTextView.setLayoutParams(mTxtParams);
        mImageView.setImageDrawable(mDrawable);
        mImageView.setLayoutParams(mImgParams);
        addView(mImageView);
        addView(mTextView);
    }

    protected void initImageView() {
        mImgParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mImgParams.gravity = Gravity.CENTER;
    }

    protected void initTextView() {
        mTxtParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTxtParams.gravity = Gravity.CENTER;
    }

    public void setTxt(String txt) {
        mTextView.setText(txt);
    }

    public void setImg(@DrawableRes int id) {
        mImageView.setImageResource(id);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mImageView.setPressed(true);
                mTextView.setPressed(true);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mImageView.setPressed(false);
                mTextView.setPressed(false);
                break;
        }
        return super.onTouchEvent(event);
    }
}
