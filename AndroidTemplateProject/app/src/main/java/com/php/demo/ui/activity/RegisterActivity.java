package com.php.demo.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gyf.barlibrary.ImmersionBar;
import com.php.demo.R;
import com.php.demo.common.MyActivity;
import com.php.demo.helper.InputTextHelper;
import com.php.widget.CountdownView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *    author : xxx
 *    xxx
 *    time   : 2018/10/18
 *    desc   : 注册界面
 */
public class RegisterActivity extends MyActivity {

    @BindView(R.id.et_register_phone)
    EditText mPhoneView;
    @BindView(R.id.cv_register_countdown)
    CountdownView mCountdownView;

    @BindView(R.id.et_register_code)
    EditText mCodeView;

    @BindView(R.id.et_register_password1)
    EditText mPasswordView1;
    @BindView(R.id.et_register_password2)
    EditText mPasswordView2;

    @BindView(R.id.btn_register_commit)
    Button mCommitView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_register_title;
    }

    @Override
    protected void initView() {
        new InputTextHelper.Builder(this)
                .setMain(mCommitView)
                .addView(mPhoneView)
                .addView(mCodeView)
                .addView(mPasswordView1)
                .addView(mPasswordView2)
                .build();
    }

    @Override
    protected void initData() {
//        getHandler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                finishResult(RESULT_OK);
//            }
//        }, 2000);
    }

    @Override
    protected ImmersionBar statusBarConfig() {
        // 不要把整个布局顶上去
        return super.statusBarConfig().keyboardEnable(true);
    }

    @OnClick({R.id.cv_register_countdown, R.id.btn_register_commit})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_register_countdown: //获取验证码

                if (mPhoneView.getText().toString().length() != 11) {
                    // 重置验证码倒计时控件
                    mCountdownView.resetState();
                    toast(getString(R.string.phone_input_error));
                } else {
                    // 获取验证码
                    toast(getString(R.string.countdown_code_send_succeed));
                }

                break;
            case R.id.btn_register_commit: //提交注册

                if (mPhoneView.getText().toString().length() != 11) {
                    toast(getString(R.string.phone_input_error));
                } else if (!mPasswordView1.getText().toString().equals(mPasswordView2.getText().toString())) {
                    toast(getString(R.string.two_password_input_error));
                } else {

                }
                break;
            default:
                break;
        }
    }
}