package com.example.jiandao;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.net.INetCallBack;

public class MainContract {
    public interface IMainView extends BaseView {
        void setData(RemBean remBean);
    }

    public interface IMainModel{
        <T> void getRecommendList(INetCallBack<T> iNetCallBack);
    }

    public interface IMainPresenter{
        void getRecommendList();
        //他两交互时，需要什么操作
    }
}
