package com.php.demo.ui.activity;

import android.support.v4.view.ViewPager;

import com.php.demo.R;
import com.php.demo.common.MyActivity;
import com.php.demo.ui.adapter.ImagePagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 *    author : xxx
 *    xxx
 *    time   : 2019/03/05
 *    desc   : 查看大图
 */
public class ImageActivity extends MyActivity {

    @BindView(R.id.vp_image_pager)
    ViewPager mViewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_image;
    }

    @Override
    protected int getTitleId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        ArrayList<String> data = new ArrayList<>();
        data.add("https://www.baidu.com/img/bd_logo.png");
        data.add("https://www.baidu.com/img/bd_logo.png");
        data.add("https://www.baidu.com/img/bd_logo.png");
        mViewPager.setAdapter(new ImagePagerAdapter(this, data));
    }

    @Override
    public boolean statusBarDarkFont() {
        return !super.statusBarDarkFont();
    }
}