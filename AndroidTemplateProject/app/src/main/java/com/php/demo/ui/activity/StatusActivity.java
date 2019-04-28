package com.php.demo.ui.activity;

import android.view.View;

import com.php.demo.R;
import com.php.demo.common.MyActivity;

/**
 *    author : xxx
 *    xxx
 *    time   : 2019/04/17
 *    desc   : 加载使用案例
 */
public class StatusActivity extends MyActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_status;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_status_title;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        showLoading();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                showComplete();
                showEmpty();
            }
        }, 3000);
    }

    @Override
    public void onRightClick(View v) {
        showError();
    }
}