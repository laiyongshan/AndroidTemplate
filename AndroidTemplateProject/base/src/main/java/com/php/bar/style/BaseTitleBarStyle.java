package com.php.bar.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

import com.php.bar.ITitleBarStyle;

public abstract class BaseTitleBarStyle implements ITitleBarStyle {

    private Context mContext;

    public BaseTitleBarStyle(Context context) {
        mContext = context;
    }

    protected Context getContext() {
        return mContext;
    }

    protected Drawable getDrawable(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getContext().getResources().getDrawable(id, null);
        } else {
            return getContext().getResources().getDrawable(id);
        }
    }

    public int getColor(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getContext().getResources().getColor(id, null);
        } else {
            return getContext().getResources().getColor(id);
        }
    }

    /**
     * dpתpx
     */
    protected int dp2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * spתpx
     */
    protected int sp2px(float spValue) {
        final float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    @Override
    public int getTitleBarHeight() {
        return dp2px(0);
    }

    @Override
    public float getLeftSize() {
        return sp2px(14);
    }

    @Override
    public float getTitleSize() {
        return sp2px(16);
    }

    @Override
    public float getRightSize() {
        return sp2px(14);
    }
}