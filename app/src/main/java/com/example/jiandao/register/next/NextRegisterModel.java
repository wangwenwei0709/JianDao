package com.example.jiandao.register.next;

import android.util.Log;

import com.example.jiandao.base.BaseModel;
import com.example.jiandao.net.INetCallBack;
import com.example.jiandao.net.NetWorkFactory;
import com.example.jiandao.net.ParamsUtils;
import com.example.jiandao.net.api.URLConstants;

import java.util.HashMap;

public class NextRegisterModel extends BaseModel implements NextRegisterContract.INextRegisterModel {
    @Override
    public <T> void register(String mobile, String password, String affirm_password, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",mobile);
        commonParams.put("password",password);
        commonParams.put("affirm_password",affirm_password);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }

        NetWorkFactory.getInstance().getNetWork().post(URLConstants.REGISTER,commonParams,iNetCallBack);
    }
}
