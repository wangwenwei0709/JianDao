package com.example.jiandao.home.view.fragment;

import android.view.View;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseFragment;
import com.example.jiandao.base.BasePresenter;

public class MeFragment extends BaseFragment {

    public static MeFragment newInstance(){
        MeFragment meFragment = new MeFragment();
        return meFragment;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_me;
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
