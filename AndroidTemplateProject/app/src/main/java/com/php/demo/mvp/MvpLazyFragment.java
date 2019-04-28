package com.php.demo.mvp;

import com.php.demo.common.MyLazyFragment;

/**
 *    author : xxx
 *    xxx
 *    time   : 2018/11/17
 *    desc   : MVP 懒加载 Fragment 基类
 */
public abstract class MvpLazyFragment<P extends MvpPresenter> extends MyLazyFragment implements IMvpView {

    private P mPresenter;

    @Override
    protected void initFragment() {
        mPresenter = createPresenter();
        mPresenter.attach(this);
        super.initFragment();
        mPresenter.start();
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detach();
            mPresenter = null;
        }
        super.onDestroy();
    }

    public P getPresenter() {
        return mPresenter;
    }

    protected abstract P createPresenter();
}