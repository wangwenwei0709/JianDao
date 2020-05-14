package com.example.jiandao.special;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.net.INetCallBack;

public class SpecialFragmentPresenter extends BasePresenter<SpecialContract.ISpecialFragmentView> implements SpecialContract.ISpecialFragmentPresenter {
    SpecialContract.ISpecialFragmentMode iSpecialFragmentMode;

    public SpecialFragmentPresenter() {
        iSpecialFragmentMode = new SpecialFragmentModel();
    }

    @Override
    public void getSpecialList() {
        iSpecialFragmentMode.getSpecialList(new INetCallBack<SpecialBean>() {
            @Override
            public void onSuccess(SpecialBean specialBean) {
                mview.setSpecialList(specialBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
