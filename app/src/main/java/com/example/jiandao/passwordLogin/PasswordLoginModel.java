package com.example.jiandao.passwordLogin;

import android.util.Log;

import com.example.jiandao.base.BaseModel;
import com.example.jiandao.net.INetCallBack;
import com.example.jiandao.net.NetWorkFactory;
import com.example.jiandao.net.ParamsUtils;
import com.example.jiandao.net.api.URLConstants;

import java.util.HashMap;

public class PasswordLoginModel extends BaseModel implements PasswordLoginContract.IPasswordLoginModel{
    @Override
    public <T> void passwordLogin(String mobile, String password, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("username",mobile);
        commonParams.put("password",password);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.PASSWORDLOGIN,commonParams,iNetCallBack);
    }
}
