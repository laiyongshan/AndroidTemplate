package com.php.demo.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.php.demo.R;
import com.php.demo.common.MyActivity;
import com.php.demo.helper.InputTextHelper;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *    author : xxx
 *    xxx
 *    time   : 2019/02/27
 *    desc   : 重置密码
 */
public class PasswordResetActivity extends MyActivity {

    @BindView(R.id.et_password_reset_password1)
    EditText mPasswordView1;
    @BindView(R.id.et_password_reset_password2)
    EditText mPasswordView2;
    @BindView(R.id.btn_password_reset_commit)
    Button mCommitView;

    private InputTextHelper mInputTextHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_password_reset;
    }

    @Override
    protected int getTitleId() {
        return R.id.tb_password_reset_title;
    }

    @Override
    protected void initView() {
        mInputTextHelper = new InputTextHelper(mCommitView);
        mInputTextHelper.addViews(mPasswordView1, mPasswordView2);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_password_reset_commit})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_password_reset_commit:
                if (!mPasswordView1.getText().toString().equals(mPasswordView2.getText().toString())) {
                    toast(getString(R.string.two_password_input_error));
                } else {
                    // 重置密码
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        mInputTextHelper.removeViews();
        super.onDestroy();
    }
}