package com.example.jiandao.register;

import com.example.jiandao.RemBean;
import com.example.jiandao.base.BaseView;
import com.example.jiandao.login.VerfiedBean;
import com.example.jiandao.net.INetCallBack;

public class RegisterContract {
    public interface IRegisterView extends BaseView {
        void getVerified(VerfiedBean s);
        void checkSmsCodeResult(VerfiedBean verfiedBean);
    }

    public interface IRegisterModel{
        <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack);
        <T> void checkSmsCode(String phoneNum,String smsCode,String type,INetCallBack<T> iNetCallBack);
    }

    public interface IRegisterPresenter{
        void getVerified(String string,String type);
        void checkSmsCode(String phoneNum,String smsCode,String type);
    }
}
