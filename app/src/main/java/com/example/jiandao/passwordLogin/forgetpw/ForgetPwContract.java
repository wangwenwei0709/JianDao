package com.example.jiandao.passwordLogin.forgetpw;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.login.LoginBean;
import com.example.jiandao.login.VerfiedBean;
import com.example.jiandao.net.INetCallBack;

public class ForgetPwContract {
    public interface IForgetPwView extends BaseView {
        void getVerified(VerfiedBean s);
        void checkSmsCodeResult(VerfiedBean verfiedBean);
    }
    public interface IForgetPwMode{
        <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack);
        <T> void checkSmsCode(String phoneNum,String smsCode,String type,INetCallBack<T> iNetCallBack);
    }
    public interface IForgetPwPresenter{
        void getVerified(String string,String type);
        void checkSmsCode(String phoneNum,String smsCode,String type);
    }
}
