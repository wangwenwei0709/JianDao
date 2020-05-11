package com.example.jiandao.passwordLogin.affirmpw;

import android.util.Log;

import com.example.jiandao.base.BaseModel;
import com.example.jiandao.net.INetCallBack;
import com.example.jiandao.net.NetWorkFactory;
import com.example.jiandao.net.ParamsUtils;
import com.example.jiandao.net.api.URLConstants;

import java.util.HashMap;

public class AffrimPwModel extends BaseModel implements AffrimPwContract.IAffrimPwMode {
    @Override
    public <T> void affrimpw(String mobile, String password, String sms_code, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",mobile);
        commonParams.put("password",password);
        commonParams.put("sms_code",sms_code);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }

        NetWorkFactory.getInstance().getNetWork().post(URLConstants.SAVEPASSWORD,commonParams,iNetCallBack);
    }
}
