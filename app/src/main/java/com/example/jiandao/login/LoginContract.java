package com.example.jiandao.login;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.net.INetCallBack;

public class LoginContract {

    public interface ILoginView extends BaseView {
        void getVerified(VerfiedBean s);
        void checkSmsCodeResult(VerfiedBean verfiedBean);
        void  getLoginResult(LoginBean loginBean);
    }
    public interface ILoginMode{
        <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack);
        <T> void checkSmsCode(String phoneNum,String smsCode,String type,INetCallBack<T> iNetCallBack);
        <T> void login(String mobile,String smsCode,INetCallBack<T> iNetCallBack);
    }
    public interface ILoginPresenter{
        void getVerified(String string,String type);
        void checkSmsCode(String phoneNum,String smsCode,String type);
        void login(String mobile,String smsCode);
    }
}
