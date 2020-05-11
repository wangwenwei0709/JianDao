package com.example.jiandao.register.next;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.login.LoginBean;
import com.example.jiandao.net.INetCallBack;

public class NextRegisterPresenter extends BasePresenter<NextRegisterContract.INextRegisterView> implements NextRegisterContract.INextRegisterPresenter{
    NextRegisterContract.INextRegisterModel iNextRegisterModel;

    public NextRegisterPresenter() {
        iNextRegisterModel = new NextRegisterModel();
    }

    @Override
    public void register(String mobile, String password, String affirm_password) {
        iNextRegisterModel.register(mobile, password, affirm_password, new INetCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                mview.register(loginBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
