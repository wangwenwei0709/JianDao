package com.example.jiandao.vp;


import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseLazyFragment;
import com.example.jiandao.details.view.DetailsActivity;

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
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("article",newsBean.getData().getArticle_list().get(position));
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
