package com.example.jiandao.home.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseFragment;
import com.example.jiandao.video.VideoFragmentBean;
import com.example.jiandao.video.VideoFragmentContract;
import com.example.jiandao.video.VideoFragmentPresenter;
import com.example.jiandao.video.VideoFragmentRvAdapter;
import com.example.jiandao.vp.NewsBean;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayer;

public class VideoFragment extends BaseFragment<VideoFragmentPresenter> implements VideoFragmentContract.IVideoFragmentView {


    @BindView(R.id.rv_video)
    RecyclerView rvVideo;
    private VideoFragmentRvAdapter adapter;

    @Override
    protected VideoFragmentPresenter initPresenter() {
        return new VideoFragmentPresenter();
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        mPresenter.getVideoList();
    }

    @Override
    public void setVideoList(VideoFragmentBean videoFragmentBean) {
        rvVideo.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new VideoFragmentRvAdapter(videoFragmentBean, getActivity());
        rvVideo.setAdapter(adapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
