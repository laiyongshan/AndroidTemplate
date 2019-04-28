package com.php.demo.ui.fragment;

import com.php.demo.R;
import com.php.demo.common.MyLazyFragment;
import com.php.demo.ui.activity.CopyActivity;

/**
 *    author : xxx
 *    xxx
 *    time   : 2018/10/18
 *    desc   : 可进行拷贝的副本
 */
public class CopyFragment extends MyLazyFragment<CopyActivity> {

    public static CopyFragment newInstance() {
        return new CopyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_copy;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.tb_copy_title;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}