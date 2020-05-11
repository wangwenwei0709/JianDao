package com.example.jiandao.passwordLogin;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.login.LoginBean;
import com.example.jiandao.net.INetCallBack;

public class PasswordLoginContract {
    public interface IPasswordLoginView extends BaseView {
        void passwordLogin(LoginBean loginBean);
    }

    public interface IPasswordLoginModel{
        <T> void passwordLogin(String mobile, String password, INetCallBack<T> iNetCallBack);
    }

    public interface IPasswordLoginPresenter{
        void passwordLogin(String mobile,String password);
    }
}
