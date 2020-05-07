package com.example.jiandao.home.view.fragment;

import android.view.View;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseFragment;
import com.example.jiandao.base.BasePresenter;

public class SpecialFragment extends BaseFragment {

    public static SpecialFragment newInstance(){
        SpecialFragment specialFragment = new SpecialFragment();
        return specialFragment;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_special;
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
