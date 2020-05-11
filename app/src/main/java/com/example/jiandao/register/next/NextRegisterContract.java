package com.example.jiandao.register.next;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.login.LoginBean;
import com.example.jiandao.login.VerfiedBean;
import com.example.jiandao.net.INetCallBack;

public class NextRegisterContract {
    public interface INextRegisterView extends BaseView {
        void  register(LoginBean loginBean);
    }

    public interface INextRegisterModel{
        <T> void register(String mobile,String password,String affirm_password,INetCallBack<T> iNetCallBack);
    }

    public interface INextRegisterPresenter{
        void register(String mobile,String password,String affirm_password);
    }
}
