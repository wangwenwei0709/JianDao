package com.example.jiandao.passwordLogin.affirmpw;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.net.INetCallBack;

public class AffrimPwPresenter extends BasePresenter<AffrimPwContract.IAffrimPwView> implements AffrimPwContract.IAffrimPwPresenter {
    AffrimPwContract.IAffrimPwMode iAffrimPwMode;

    public AffrimPwPresenter() {
        iAffrimPwMode = new AffrimPwModel();
    }

    @Override
    public void affrimpw(String mobile, String password, String sms_code) {
        iAffrimPwMode.affrimpw(mobile, password, sms_code, new INetCallBack<AffrimPwBean>() {
            @Override
            public void onSuccess(AffrimPwBean affrimPwBean) {
                mview.affrimpw(affrimPwBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
