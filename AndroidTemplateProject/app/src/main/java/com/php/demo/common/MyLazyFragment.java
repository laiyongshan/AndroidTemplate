package com.php.demo.common;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.php.bar.TitleBar;
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
 *    desc   : 项目中 Fragment 懒加载基类
 */
public abstract class MyLazyFragment<A extends MyActivity> extends UILazyFragment<A> {

    private Unbinder mButterKnife; // View注解

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mButterKnife = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initFragment() {
        super.initFragment();
        EventBusManager.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mButterKnife != null) {
            mButterKnife.unbind();
        }
        EventBusManager.unregister(this);
    }

    @Nullable
    public TitleBar getTitleBar() {
        if (getTitleBarId() > 0 && findViewById(getTitleBarId()) instanceof TitleBar) {
            return findViewById(getTitleBarId());
        }
        return null;
    }

    /**
     * 显示吐司
     */
    public void toast(CharSequence s) {
        ToastUtils.show(s);
    }

    public void toast(int id) {
        ToastUtils.show(id);
    }

    public void toast(Object object) {
        ToastUtils.show(object);
    }

    /**
     * 打印日志
     */
    public void log(Object object) {
        if (DebugUtils.isDebug(getBindingActivity())) {
            Log.v(getClass().getSimpleName(), object != null ? object.toString() : "null");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        UmengClient.onResume(this);
    }

    @Override
    public void onPause() {
        UmengClient.onPause(this);
        super.onPause();
    }

    private final HintManager mHintManager = new HintManager();

    /**
     * 显示加载中
     */
    public void showLoading() {
        mHintManager.showLoading(getBindingActivity());
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
        mHintManager.showEmpty(getView());
    }

    /**
     * 显示错误提示
     */
    public void showError() {
        mHintManager.showError(getView());
    }

    /**
     * 显示自定义提示
     */
    public void showLayout(@DrawableRes int iconId, @StringRes int textId) {
        mHintManager.showLayout(getView(), iconId, textId);
    }

    public void showLayout(Drawable drawable, CharSequence hint) {
        mHintManager.showLayout(getView(), drawable, hint);
    }
}