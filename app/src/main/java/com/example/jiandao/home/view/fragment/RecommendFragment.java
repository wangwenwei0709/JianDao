package com.example.jiandao.home.view.fragment;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseFragment;
import com.example.jiandao.recommend.RecommendBean;
import com.example.jiandao.recommend.RecommendContract;
import com.example.jiandao.recommend.RecommendPresenter;
import com.example.jiandao.vp.VpAdapter;
import com.example.jiandao.vp.VpFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.IRecommendView {

    @BindView(R.id.tab_recommend)
    TabLayout tabRecommend;
    @BindView(R.id.vp_recommend)
    ViewPager vpRecommend;

    private ArrayList<Fragment> fragments;
    private List<ColumnBean.DataBean.ListBean> list;


    @Override
    protected RecommendPresenter initPresenter() {
        return new RecommendPresenter();
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        mPresenter.getColumnList();
    }


    @Override
    public void setColumnList(ColumnBean columnBean) {
        list = columnBean.getData().getList();
        fragments = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            VpFragment vpFragment = new VpFragment(columnBean.getData().getList().get(i).getId());

            fragments.add(vpFragment);
        }

        tab(columnBean);

        for (int i = 0; i < list.size();   i++) {
            TextView view = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.textitem, null);
            view.setGravity(Gravity.CENTER);
            view.setText(list.get(i).getName());
            tabRecommend.getTabAt(i).setCustomView(view);
        }


    }

    private void tab(ColumnBean columnBean) {

        VpAdapter vpAdapter = new VpAdapter(getFragmentManager(), fragments);
        vpRecommend.setAdapter(vpAdapter);
        tabRecommend.setupWithViewPager(vpRecommend);
        vpRecommend.setCurrentItem(0);

        tabRecommend.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0; i < columnBean.getData().getList().size(); i++) {
                    TextView tabAt = (TextView) tabRecommend.getTabAt(i).getCustomView();
                    tabAt.setBackgroundResource(R.color.colorwhite);
                }

                GradientDrawable drawable = new GradientDrawable();
                drawable.setCornerRadius(50);

                TextView customView = (TextView) tab.getCustomView();
                drawable.setStroke(1, Color.parseColor("#ff00ff"));
                drawable.setColor(Color.parseColor("#"+columnBean.getData().getList().get(tab.getPosition()).getBack_color()));
                customView.setBackground(drawable);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void setRecommendList(RecommendBean recommendBean) {


    }
}
