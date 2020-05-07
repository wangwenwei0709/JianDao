package com.example.jiandao.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView{

    public P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(getLayoutID(), container, false);
        ButterKnife.bind(this,view);
        mPresenter = initPresenter();
        if (mPresenter!=null) {
            mPresenter.AttachView(this);
        }
        initView(view);
        initData();
        initListener();
        return view;
    }

    protected abstract P initPresenter();


    public abstract int getLayoutID();

    protected abstract void initListener();

    protected abstract void initView(View view);

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.disAttachView();
    }
}
