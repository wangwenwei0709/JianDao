package com.example.jiandao.details.contract;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.details.bean.ArticleAttributeBean;
import com.example.jiandao.details.bean.CollectBean;
import com.example.jiandao.details.bean.CommentBean;
import com.example.jiandao.details.bean.DetailsBean;
import com.example.jiandao.login.VerfiedBean;
import com.example.jiandao.net.INetCallBack;

public class DetailsContract {
    public interface IDetailsView extends BaseView {
        void getArticleDetails(DetailsBean s);//获取文章详情关联列表
        void collect(VerfiedBean collectBean);//收藏
        void like(VerfiedBean collectBean);//点赞
        void addUserIntegalResult(VerfiedBean collectBean);//阅读文件，增加积分
        void getCommentList(CommentBean commentBean);//获取文章评论列表
    }
    public interface IDetailsMode{
        <T> void getArticleDetails(String id, INetCallBack<T> iNetCallBack);
        <T> void collect(String id, int type, INetCallBack<T> iNetCallBack);
        <T> void like(String id,int type,INetCallBack<T> iNetCallBack);
        <T> void addUserIntegral(String id,INetCallBack<T> iNetCallBack);
        <T> void getCommentList(String id,String start,String point_time,INetCallBack<T> iNetCallBack);

    }
    public interface IDetailsPresenter{
        void getArticleDetails(String id);
        void collect(String id, int type);
        void like(String id,int type);
        void addUserIntegral(String id);
        void getCommentList(String id,String start,String point_time);
    }
}
