package com.example.jiandao.video;

import android.util.Log;

import com.example.jiandao.base.BaseModel;
import com.example.jiandao.net.INetCallBack;
import com.example.jiandao.net.NetWorkFactory;
import com.example.jiandao.net.ParamsUtils;
import com.example.jiandao.net.api.URLConstants;

import java.util.HashMap;

public class VideoFragmentModel extends BaseModel implements VideoFragmentContract.IVideoFragmentMode {
    @Override
    public <T> void getVideoList(INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("start","0");
        commonParams.put("number ","0");
        commonParams.put("point_time","0");
//        此处  -- 登录以后，  需要修改

        for (String key: commonParams.keySet()) {
            Log.e("TAG2","key2="+key+",values2="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.VEDIO_LIST,commonParams,iNetCallBack);
    }
}
