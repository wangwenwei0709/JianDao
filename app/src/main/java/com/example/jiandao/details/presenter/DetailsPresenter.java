package com.example.jiandao.details.presenter;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.details.bean.ArticleAttributeBean;
import com.example.jiandao.details.bean.CollectBean;
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
    public void collect(String id, String type, String token) {
        iDetailsMode.collect(id, type, token, new INetCallBack<CollectBean>() {
            @Override
            public void onSuccess(CollectBean collectBean) {
                mview.collect(collectBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getarticleattribute(String id, String token) {
        iDetailsMode.getarticleattribute(id, token, new INetCallBack<ArticleAttributeBean>() {
            @Override
            public void onSuccess(ArticleAttributeBean articleAttributeBean) {
                mview.getarticleattribute(articleAttributeBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
