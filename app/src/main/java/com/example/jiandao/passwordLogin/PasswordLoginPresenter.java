package com.example.jiandao.passwordLogin;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.login.LoginBean;
import com.example.jiandao.net.INetCallBack;

public class PasswordLoginPresenter extends BasePresenter<PasswordLoginContract.IPasswordLoginView> implements PasswordLoginContract.IPasswordLoginPresenter{
    PasswordLoginContract.IPasswordLoginModel iPasswordLoginModel;

    public PasswordLoginPresenter() {
        iPasswordLoginModel = new PasswordLoginModel();
    }

    @Override
    public void passwordLogin(String mobile, String password) {
        iPasswordLoginModel.passwordLogin(mobile, password, new INetCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                mview.passwordLogin(loginBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
