package com.php.demo.mvp;

/**
 *    author : xxx
 *    xxx
 *    time   : 2018/11/17
 *    desc   : MVP 模型基类
 */
public abstract class MvpModel<L> {

    private L mListener;

    public void setListener(L l) {
        mListener = l;
    }

    public L getListener() {
        return mListener;
    }
}