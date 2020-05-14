package com.example.jiandao.special;

import android.util.Log;

import com.example.jiandao.base.BaseModel;
import com.example.jiandao.net.INetCallBack;
import com.example.jiandao.net.NetWorkFactory;
import com.example.jiandao.net.ParamsUtils;
import com.example.jiandao.net.api.URLConstants;

import java.util.HashMap;

public class SpecialFragmentModel extends BaseModel implements SpecialContract.ISpecialFragmentMode {
    @Override
    public <T> void getSpecialList(INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("start","0");
        commonParams.put("number ","0");
        commonParams.put("point_time","0");
//        此处  -- 登录以后，  需要修改

        for (String key: commonParams.keySet()) {
            Log.e("TAG3","key3="+key+",values3="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.SPECIAL_LIST,commonParams,iNetCallBack);
    }
}
