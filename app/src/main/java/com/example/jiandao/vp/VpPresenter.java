package com.example.jiandao.vp;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.net.INetCallBack;

public class VpPresenter extends BasePresenter<VpFragmentContract.INewsView> implements VpFragmentContract.INewsPresenter{
    private VpFragmentContract.INewsMode iNewsMode;

    public VpPresenter() {
        iNewsMode = new VpModel();
    }

    @Override
    public void getRecommend(String id) {
        iNewsMode.getRecommendList(id, new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                mview.setRecommendList(newsBean.getData());
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
