package com.example.jiandao.vp;


import com.example.jiandao.base.BaseView;
import com.example.jiandao.net.INetCallBack;

import java.util.List;

public class VpFragmentContract {

    public interface INewsView extends BaseView {
        void  setRecommendList(NewsBean dataBean);
    }
    public interface INewsMode{
        <T> void getRecommendList(String tabID, INetCallBack<T> iNetCallBack);
    }
    public interface INewsPresenter{
        void getRecommend(String string);
    }
}
