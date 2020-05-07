package com.example.jiandao.recommend;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.home.view.fragment.ColumnBean;
import com.example.jiandao.net.INetCallBack;

public class RecommendContract {
    public interface IRecommendView extends BaseView{
        void setColumnList(ColumnBean columnBean);
        void setRecommendList(RecommendBean recommendList);
    }

    public interface IRecommendModel{
        <T> void getColumnList(INetCallBack<T> iNetCallBack);
        <T> void getRecommendList(String id,INetCallBack<T> iNetCallBack);
    }

    public interface IRecommendPresenter{
        void getColumnList();
        void getRecommendList(String id);
        //他两交互时，需要什么操作
    }
}
