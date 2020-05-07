package com.example.jiandao.home.view.fragment;

import android.view.View;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseFragment;
import com.example.jiandao.base.BasePresenter;

public class VideoFragment extends BaseFragment {

    public static VideoFragment newInstance(){
        VideoFragment videoFragment = new VideoFragment();
        return videoFragment;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}
