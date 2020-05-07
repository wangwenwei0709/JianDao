package com.example.jiandao.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        mPresenter.AttachView(this);
        initView();
        initData();
        initListener();
    }

    protected abstract P initPresenter();

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();

    public abstract int getLayoutID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.disAttachView();
    }
}
