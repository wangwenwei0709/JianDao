package com.example.jiandao.video;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.net.INetCallBack;

public class VideoFragmentContract {
    public interface IVideoFragmentView extends BaseView {
        void  setVideoList(VideoFragmentBean videoFragmentBean);
    }
    public interface IVideoFragmentMode{
        <T> void getVideoList(INetCallBack<T> iNetCallBack);
    }
    public interface IVideoFragmentPresenter{
        void getVideoList();
    }
}
