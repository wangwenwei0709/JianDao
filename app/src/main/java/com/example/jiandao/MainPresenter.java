package com.example.jiandao;

import android.util.Log;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.net.INetCallBack;

public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.IMainPresenter{

    private MainContract.IMainModel iMainModel;

    public MainPresenter() {
        iMainModel = new MainModel();
    }

    @Override
    public void getRecommendList() {
        iMainModel.getRecommendList(new INetCallBack<RemBean>() {
            @Override
            public void onSuccess(RemBean remBean) {
                Log.e("TAG","打印网络请求返回实体类:"+remBean.toString());
                mview.setData(remBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
