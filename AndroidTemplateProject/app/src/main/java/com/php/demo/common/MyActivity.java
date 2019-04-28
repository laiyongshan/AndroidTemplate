package com.php.demo.common;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.View;

import com.php.bar.OnTitleBarListener;
import com.php.bar.TitleBar;
import com.php.demo.helper.ActivityStackManager;
import com.php.demo.helper.DebugUtils;
import com.php.demo.other.EventBusManager;
import com.php.demo.other.HintManager;
import com.php.toast.ToastUtils;
import com.php.umeng.UmengClient;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *    author : xxx
 *    xxx
 *    time   : 2018/10/18
 *    desc   : 项目中的 Activity 基类
 */
public abstract class MyActivity extends UIActivity
        implements OnTitleBarListener {

    @Override
    protected void initActivity() {
        super.initActivity();
        ActivityStackManager.getInstance().onActivityCreated(this);
    }

    // ButterKnife 注解
    private Unbinder mButterKnife;

    @Override
    protected void initLayout() {
        super.initLayout();

        // 初始化标题栏的监听
        if (getTitleId() > 0) {
            if (findViewById(getTitleId()) instanceof TitleBar) {
                ((TitleBar) findViewById(getTitleId())).setOnTitleBarListener(this);
            }
        }

        mButterKnife = ButterKnife.bind(this);
        EventBusManager.register(this);
        initOrientation();
    }

    /**
     * 初始化横竖屏方向，会和 LauncherTheme 主题样式有冲突，注意不要同时使用
     */
    protected void initOrientation() {
        // 当前 Activity 不能是透明的并且没有指定屏幕方向，默认设置为竖屏
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    /**
     * 设置标题栏的标题
     */
    @Override
    public void setTitle(int titleId) {
        setTitle(getText(titleId));
    }

    /**
     * 设置标题栏的标题
     */
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        TitleBar titleBar = getTitleBar();
        if (titleBar != null) {
            titleBar.setTitle(title);
        }
    }

    @Nullable
    public TitleBar getTitleBar() {
        if (getTitleId() > 0 && findViewById(getTitleId()) instanceof TitleBar) {
            return findViewById(getTitleId());
        }
        return null;
    }

    @Override
    public boolean statusBarDarkFont() {
        //返回true表示黑色字体
        return true;
    }

    /**
     * {@link OnTitleBarListener}
     */

    // TitleBar 左边的View被点击了
    @Override
    public void onLeftClick(View v) {
        onBackPressed();
    }

    // TitleBar 中间的View被点击了
    @Override
    public void onTitleClick(View v) {}

    // TitleBar 右边的View被点击了
    @Override
    public void onRightClick(View v) {}

    @Override
    protected void onResume() {
        super.onResume();
        UmengClient.onResume(this);
    }

    @Override
    protected void onPause() {
        UmengClient.onPause(this);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mButterKnife != null) mButterKnife.unbind();
        EventBusManager.unregister(this);
        ActivityStackManager.getInstance().onActivityDestroyed(this);
    }

    /**
     * 显示吐司
     */
    public void toast(CharSequence s) {
        ToastUtils.show(s);
    }

    public void toast(@StringRes int id) {
        // https://github.com/getActivity/ToastUtils/issues/31
        ToastUtils.show(getString(id));
    }

    public void toast(Object object) {
        ToastUtils.show(object);
    }

    /**
     * 打印日志
     */
    public void log(Object object) {
        if (DebugUtils.isDebug(this)) {
            Log.v(getClass().getSimpleName(), object != null ? object.toString() : "null");
        }
    }

    /**
     * 获取当前的 Application 对象
     */
    public final MyApplication getMyApplication() {
        return (MyApplication) getApplication();
    }

    private final HintManager mHintManager = new HintManager();

    /**
     * 显示加载中
     */
    public void showLoading() {
        mHintManager.showLoading(this);
    }

    /**
     * 显示加载完成
     */
    public void showComplete() {
        mHintManager.showComplete();
    }

    /**
     * 显示空提示
     */
    public void showEmpty() {
        mHintManager.showEmpty(getContentView());
    }

    /**
     * 显示错误提示
     */
    public void showError() {
        mHintManager.showError(getContentView());
    }

    /**
     * 显示自定义提示
     */
    public void showLayout(@DrawableRes int iconId, @StringRes int textId) {
        mHintManager.showLayout(getContentView(), iconId, textId);
    }

    public void showLayout(Drawable drawable, CharSequence hint) {
        mHintManager.showLayout(getContentView(), drawable, hint);
    }
}