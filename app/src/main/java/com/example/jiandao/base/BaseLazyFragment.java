package com.example.jiandao.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseLazyFragment<T extends BasePresenter> extends Fragment implements BaseView  {

    private boolean IS_VIEW_CREATED = false;
    public boolean IS_DATA_LOAD = false;
    protected T mPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyLoad();
    }

    //重启—获取焦点
    @Override
    public void onResume() {
        super.onResume();
        isCurrentVisibleToUser(true );
    }

    //暂停—失去焦点
    @Override
    public void onPause() {
        super.onPause();
        isCurrentVisibleToUser(false );
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //true  false   可见或不可见
        lazyLoad();
        isCurrentVisibleToUser(isVisibleToUser);
    }

    private void lazyLoad(){
        //        true可见    1、当前页面是否可见   2、当前页面是否已经加载   3、当前页面数据是否已经加载
        if (getUserVisibleHint() && !IS_DATA_LOAD && IS_VIEW_CREATED){
            initData();//加载数据
            IS_DATA_LOAD = true;
        }else {

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(getLayoutID(), container, false);
        IS_VIEW_CREATED = true;
        mPresenter = initPresenter();
        if (null != mPresenter){
            mPresenter.AttachView(this);
        }
        initView(view);
        initListener();
        return view;
    }

    protected abstract T initPresenter();

    public abstract int getLayoutID();

    protected abstract void initListener();

    protected abstract void initView(View view);

    protected abstract void initData();

    public abstract void isCurrentVisibleToUser(boolean isVisible);
}
