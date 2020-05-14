package com.example.jiandao.details.contract;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.details.bean.ArticleAttributeBean;
import com.example.jiandao.details.bean.CollectBean;
import com.example.jiandao.details.bean.DetailsBean;
import com.example.jiandao.net.INetCallBack;

public class DetailsContract {
    public interface IDetailsView extends BaseView {
        void getArticleDetails(DetailsBean s);
        void collect(CollectBean collectBean);
        void getarticleattribute(ArticleAttributeBean articleAttributeBean);

    }
    public interface IDetailsMode{
        <T> void getArticleDetails(String id, INetCallBack<T> iNetCallBack);
        <T> void collect(String id, String type, String token, INetCallBack<T> iNetCallBack);
        <T> void getarticleattribute(String id, String token, INetCallBack<T> iNetCallBack);

    }
    public interface IDetailsPresenter{
        void getArticleDetails(String id);
        void collect(String id, String type, String token);
        void getarticleattribute(String id, String token);
    }
}
