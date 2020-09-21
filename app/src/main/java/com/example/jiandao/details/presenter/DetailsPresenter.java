package com.example.jiandao.details.presenter;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.details.bean.ArticleAttributeBean;
import com.example.jiandao.details.bean.CollectBean;
import com.example.jiandao.details.bean.CommentBean;
import com.example.jiandao.details.bean.DetailsBean;
import com.example.jiandao.details.contract.DetailsContract;
import com.example.jiandao.details.model.DetailsModel;
import com.example.jiandao.login.VerfiedBean;
import com.example.jiandao.net.INetCallBack;

import okhttp3.ResponseBody;

public class DetailsPresenter extends BasePresenter<DetailsContract.IDetailsView> implements DetailsContract.IDetailsPresenter {
    DetailsContract.IDetailsMode iDetailsMode;

    public DetailsPresenter() {
        iDetailsMode = new DetailsModel();
    }

    @Override
    public void getArticleDetails(String id) {
        iDetailsMode.getArticleDetails(id, new INetCallBack<DetailsBean>() {
            @Override
            public void onSuccess(DetailsBean detailsBean) {
                mview.getArticleDetails(detailsBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void collect(String id, int type) {
        iDetailsMode.collect(id, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean collectBean) {
                mview.collect(collectBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void like(String id, int type) {
        iDetailsMode.like(id, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.like(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void addUserIntegral(String id) {

    }

    @Override
    public void getCommentList(String id, String start, String point_time) {
        iDetailsMode.getCommentList(id, start, point_time, new INetCallBack<CommentBean>() {
            @Override
            public void onSuccess(CommentBean commentBean) {
                mview.getCommentList(commentBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }


}
