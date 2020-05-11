package com.example.jiandao.passwordLogin.forgetpw;

import com.example.jiandao.base.BasePresenter;

public class ForgetPwPresenter extends BasePresenter<ForgetPwContract.IForgetPwView> implements ForgetPwContract.IForgetPwPresenter {
    ForgetPwContract.IForgetPwMode iForgetPwMode;

    public ForgetPwPresenter() {
        iForgetPwMode = new ForgetPwModel();
    }

    @Override
    public void getVerified(String string, String type) {

    }

    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {

    }
}
