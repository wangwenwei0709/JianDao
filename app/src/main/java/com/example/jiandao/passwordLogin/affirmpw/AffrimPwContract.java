package com.example.jiandao.passwordLogin.affirmpw;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.login.VerfiedBean;
import com.example.jiandao.net.INetCallBack;

public class AffrimPwContract {
    public interface IAffrimPwView extends BaseView {
        void affrimpw(AffrimPwBean affrimPwBean);
    }
    public interface IAffrimPwMode{
        <T> void affrimpw(String mobile, String password,String sms_code,INetCallBack<T> iNetCallBack);
    }
    public interface IAffrimPwPresenter{
        void affrimpw(String mobile,String password,String sms_code);
    }
}
