package com.example.jiandao.register;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.login.VerfiedBean;
import com.example.jiandao.net.INetCallBack;

public class RegisterPresenter extends BasePresenter<RegisterContract.IRegisterView> implements RegisterContract.IRegisterPresenter{

    RegisterContract.IRegisterModel iRegisterModel;

    public RegisterPresenter() {
        iRegisterModel = new RegisterModel();
    }
    @Override
    public void getVerified(String string, String type) {
        iRegisterModel.getVerified(string, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.getVerified(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {
        iRegisterModel.checkSmsCode(phoneNum, smsCode, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.checkSmsCodeResult(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
