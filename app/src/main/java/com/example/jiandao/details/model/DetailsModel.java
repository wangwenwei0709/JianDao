package com.example.jiandao.details.model;

import android.util.Log;

import com.example.jiandao.base.BaseModel;
import com.example.jiandao.details.contract.DetailsContract;
import com.example.jiandao.net.INetCallBack;
import com.example.jiandao.net.NetWorkFactory;
import com.example.jiandao.net.ParamsUtils;
import com.example.jiandao.net.api.URLConstants;

import java.util.HashMap;

public class DetailsModel extends BaseModel implements DetailsContract.IDetailsMode {
    @Override
    public <T> void getArticleDetails(String id, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("id",id);

        for (String key: commonParams.keySet()) {
            Log.e("TAG4","key4="+key+",values4="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.ARTICLEACCESS,commonParams,iNetCallBack);
    }

    @Override
    public <T> void collect(String id, String type, String token, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("id",id);
        commonParams.put("type",type);
        commonParams.put("token",token);

        for (String key: commonParams.keySet()) {
            Log.e("TAGCOLLECT","key4="+key+",values4="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.USERCOLLECT,commonParams,iNetCallBack);
    }

    @Override
    public <T> void getarticleattribute(String id, String token, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("id",id);
        commonParams.put("token",token);

        for (String key: commonParams.keySet()) {
            Log.e("TAGCOLLECT","key4="+key+",values4="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.ARTICLEATTRIBUTE,commonParams,iNetCallBack);
    }
}
