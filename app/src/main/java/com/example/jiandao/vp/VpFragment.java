package com.example.jiandao.vp;


import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.jiandao.R;
import com.example.jiandao.base.BaseFragment;
import com.example.jiandao.base.BaseLazyFragment;
import com.example.jiandao.details.view.DetailsActivity;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayer;

public class VpFragment extends BaseLazyFragment<VpPresenter> implements VpFragmentContract.INewsView {


    private RecyclerView rvVp;
    private String tabID;
    private VpRvAdapter adapter;


    public VpFragment(String tabID) {
        this.tabID = tabID;
    }

    @Override
    protected VpPresenter initPresenter() {
        return new VpPresenter();
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_vp;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        rvVp = view.findViewById(R.id.rv_vp);
    }

    @Override
    protected void initData() {
        mPresenter.getRecommend(tabID);
    }

    @Override
    public void isCurrentVisibleToUser(boolean isVisible) {
        //当前Framgnet是显示还是隐藏
        if (adapter !=null) adapter.isCurrentVisibleToUser(isVisible);
    }

    @Override
    public void setRecommendList(NewsBean newsBean) {
        rvVp.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvVp.addItemDecoration(new DividerItemDecoration(getContext(), OrientationHelper.VERTICAL));
        adapter = new VpRvAdapter(newsBean,getActivity());
        rvVp.setAdapter(adapter);

        adapter.setOnItemClick(new VpRvAdapter.OnItemClick() {
            @Override
            public void onClick(int position) {
                NewsBean.DataBean.ArticleListBean articleListBean = newsBean.getData().getArticle_list().get(position);
                String id = articleListBean.getId();
                String link = articleListBean.getLink();
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("link",link);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
