package com.example.jiandao.login;

import android.util.Log;
import android.widget.Toast;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.net.INetCallBack;

import java.io.IOException;

import okhttp3.ResponseBody;

public class LoginPresenter extends BasePresenter<LoginContract.ILoginView> implements LoginContract.ILoginPresenter{
    LoginContract.ILoginMode iLoginMode;

    public LoginPresenter() {
        iLoginMode = new LoginModel();
    }


    @Override
    public void getVerified(String string, String type) {
        iLoginMode.getVerified(string, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                Log.e("TAG", "收到的验证码是："+verfiedBean.getData());
                mview.getVerified(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {
        iLoginMode.checkSmsCode(phoneNum, smsCode, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.checkSmsCodeResult(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void login(String mobile, String smsCode) {
        iLoginMode.login(mobile, smsCode, new INetCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                mview.getLoginResult(loginBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
