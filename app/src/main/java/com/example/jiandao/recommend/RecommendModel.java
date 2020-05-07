package com.example.jiandao.recommend;

import android.util.Log;

import com.example.jiandao.base.BaseModel;
import com.example.jiandao.net.INetCallBack;
import com.example.jiandao.net.NetWorkFactory;
import com.example.jiandao.net.ParamsUtils;
import com.example.jiandao.net.api.URLConstants;
import com.example.jiandao.recommend.RecommendContract;

import java.util.HashMap;

public class RecommendModel extends BaseModel implements RecommendContract.IRecommendModel{

    public RecommendModel() {
    }

    @Override
    public <T> void getColumnList(INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.COLUMN_LIST ,commonParams,iNetCallBack);
    }

    @Override
    public <T> void getRecommendList(String id,INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("id",id);
        commonParams.put("start","0");
        commonParams.put("number","0");
        commonParams.put("point_time ","0");

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.RECOMMEND_LIST ,commonParams,iNetCallBack);
    }
}
