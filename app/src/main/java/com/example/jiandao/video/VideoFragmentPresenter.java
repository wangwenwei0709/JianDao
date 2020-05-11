package com.example.jiandao.video;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.net.INetCallBack;
import com.example.jiandao.vp.NewsBean;

public class VideoFragmentPresenter extends BasePresenter<VideoFragmentContract.IVideoFragmentView> implements VideoFragmentContract.IVideoFragmentPresenter {
    VideoFragmentContract.IVideoFragmentMode iVideoFragmentMode;

    public VideoFragmentPresenter() {
        iVideoFragmentMode = new VideoFragmentModel();
    }

    @Override
    public void getVideoList() {
        iVideoFragmentMode.getVideoList(new INetCallBack<VideoFragmentBean>() {
            @Override
            public void onSuccess(VideoFragmentBean videoFragmentBean) {
                mview.setVideoList(videoFragmentBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
