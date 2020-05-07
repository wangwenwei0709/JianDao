package com.example.jiandao.recommend;

import android.util.Log;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.home.view.fragment.ColumnBean;
import com.example.jiandao.home.view.fragment.RecommendFragment;
import com.example.jiandao.net.INetCallBack;
import com.example.jiandao.recommend.RecommendContract;
import com.example.jiandao.recommend.RecommendModel;

public class RecommendPresenter extends BasePresenter<RecommendContract.IRecommendView> implements RecommendContract.IRecommendPresenter{

    private RecommendContract.IRecommendModel iRecommendModel;

    public RecommendPresenter() {
        iRecommendModel = new RecommendModel();
    }


    @Override
    public void getColumnList() {
        iRecommendModel.getColumnList(new INetCallBack<ColumnBean>() {
            @Override
            public void onSuccess(ColumnBean columnBean) {
                Log.e("TAG","打印网络请求返回实体类:"+columnBean.toString());
                mview.setColumnList(columnBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getRecommendList(String id) {
        iRecommendModel.getRecommendList(id,new INetCallBack<RecommendBean>() {
            @Override
            public void onSuccess(RecommendBean recommendBean) {
                mview.setRecommendList(recommendBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
