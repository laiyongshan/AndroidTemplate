package com.php.demo.mvp.copy;

import com.php.demo.mvp.IMvpView;

import java.util.List;

/**
 *    author : xxx
 *    xxx
 *    time   : 2018/11/17
 *    desc   : 可进行拷贝的契约类
 */
public class CopyContract {

    public interface View extends IMvpView {

        void loginError(String msg);

        void loginSuccess(List<String> data);
    }

    public interface Presenter {
        void login(String account, String password);
    }
}