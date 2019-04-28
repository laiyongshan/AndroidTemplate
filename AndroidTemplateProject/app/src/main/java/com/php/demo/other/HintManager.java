package com.php.demo.other;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;

import com.php.base.BaseDialog;
import com.php.demo.R;
import com.php.dialog.WaitDialog;
import com.php.widget.HintLayout;

/**
 *    author : xxx
 *    xxx
 *    time   : 2019/04/18
 *    desc   : 界面提示管理类
 */
public class HintManager {

    // 加载对话框
    private BaseDialog mDialog;

    // 提示布局
    private HintLayout mHintLayout;

    /**
     * 显示加载中
     */
    public void showLoading(FragmentActivity activity) {
        if (mDialog == null) {
            mDialog = new WaitDialog.Builder(activity)
                    .setMessage("加载中...") // 消息文本可以不用填写
                    .create();
        }

        if (!mDialog.isShowing()) {
            mDialog.show();
        }
    }

    /**
     * 显示加载完成
     */
    public void showComplete() {

        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }

        if (mHintLayout != null && mHintLayout.isShow()) {
            mHintLayout.hide();
        }
    }

    /**
     * 显示空提示
     */
    public void showEmpty(View view) {
        showLayout(view, R.mipmap.icon_hint_empty, R.string.hint_layout_no_data);
    }

    /**
     * 显示错误提示
     */
    public void showError(View view) {
        showLayout(view, R.mipmap.icon_error_nerwork, R.string.hint_layout_error_network);
    }

    /**
     * 显示自定义提示
     */
    public void showLayout(View view, @DrawableRes int iconId, @StringRes int textId) {
        showLayout(view, view.getResources().getDrawable(iconId), view.getResources().getString(textId));
    }

    public void showLayout(View view, Drawable drawable, CharSequence hint) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }

        if (mHintLayout == null) {

            if (view instanceof HintLayout) {
                mHintLayout = (HintLayout) view;
            }else if (view instanceof ViewGroup) {
                mHintLayout = findHintLayout((ViewGroup) view);
            }

            if (mHintLayout == null) {
                throw new IllegalStateException("You didn't add this HintLayout to your Activity layout");
            }
        }
        mHintLayout.show();
        mHintLayout.setIcon(drawable);
        mHintLayout.setHint(hint);
    }

    /**
     * 智能获取布局中的 HintLayout 对象
     */
    private static HintLayout findHintLayout(ViewGroup group) {
        for (int i = 0; i < group.getChildCount(); i++) {
            View view = group.getChildAt(i);
            if ((view instanceof HintLayout)) {
                return (HintLayout) view;
            } else if (view instanceof ViewGroup) {
                HintLayout layout = findHintLayout((ViewGroup) view);
                if (layout != null) return layout;
            }
        }
        return null;
    }
}