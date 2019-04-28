package com.php.demo.ui.fragment;

import android.view.View;

import com.php.demo.R;
import com.php.demo.common.MyLazyFragment;
import com.php.demo.ui.activity.HomeActivity;
import com.php.widget.CountdownView;
import com.php.widget.SwitchButton;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *    author : xxx
 *    xxx
 *    time   : 2018/10/18
 *    desc   : 项目自定义控件展示
 */
public class TestFragmentB extends MyLazyFragment<HomeActivity>
        implements SwitchButton.OnCheckedChangeListener {

    @BindView(R.id.sb_test_switch)
    SwitchButton mSwitchButton;

    @BindView(R.id.cv_test_countdown)
    CountdownView mCountdownView;

    public static TestFragmentB newInstance() {
        return new TestFragmentB();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test_b;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.tb_test_b_title;
    }

    @Override
    protected void initView() {
        mSwitchButton.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.cv_test_countdown)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_test_countdown:
                toast(getResources().getString(R.string.countdown_code_send_succeed));
                break;
            default:
                break;
        }
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    /**
     * {@link SwitchButton.OnCheckedChangeListener}
     */

    @Override
    public void onCheckedChanged(SwitchButton button, boolean isChecked) {
        toast(isChecked);
    }
}