package com.example.jiandao.vp;


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
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public class VpFragment extends BaseFragment<VpPresenter> implements VpFragmentContract.INewsView {


    private RecyclerView rvVp;
    private ViewPager bannerVp;
    private Banner_Indicator bannerIndicator;

    private String tabID;
    private ArrayList<NewsBean.DataBean.ArticleListBean> newsBeans;
    private VpRvAdapter adapter;
    private ArrayList<View> banner_views = new ArrayList<>();
    private int banner_item;
    private int viewpage_Current_Pos = 0;


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
        bannerVp = view.findViewById(R.id.banner_vp);
        bannerIndicator =view.findViewById(R.id.banner_indicator);
        rvVp = view.findViewById(R.id.rv_vp);



        rvVp.setLayoutManager(new LinearLayoutManager(getContext()));
        rvVp.addItemDecoration(new DividerItemDecoration(getContext(), OrientationHelper.VERTICAL));
        newsBeans = new ArrayList<>();
        adapter = new VpRvAdapter(newsBeans, getContext());
        rvVp.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        mPresenter.getRecommend(tabID);
    }

    @Override
    public void setRecommendList(NewsBean.DataBean articleListBeans) {
        newsBeans.addAll(articleListBeans.getArticle_list());
        adapter.notifyDataSetChanged();
        /*Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewpage_Current_Pos +=1;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bannerVp.setCurrentItem(viewpage_Current_Pos%(newsBean.getData().getBanner_list().size()));
                    }
                });
            }
        };
        timer.schedule(timerTask,2000,2000);*/
        initBanner(articleListBeans.getBanner_list());

    }


    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    private void initBanner(List<NewsBean.DataBean.BannerListBean> newsBean) {
        for (int i = 0; i < newsBean.size(); i++) {
            banner_item=i;
            View view = LayoutInflater.from(getContext()).inflate(R.layout.vp_banner_item, null, false);
            ImageView bannerimage = view.findViewById(R.id.banner_image);
            TextView bannercontext = view.findViewById(R.id.banner_content);
            bannercontext.setText(newsBean.get(i).getTheme());
            Glide.with(getContext()).load(newsBean.get(i).getImage_url()).into(bannerimage);
            banner_views.add(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "点击了"+banner_item+"个view", Toast.LENGTH_SHORT).show();
                }
            });
        }

        VpBannerAdapter vpBannerAdapter = new VpBannerAdapter(banner_views);
        bannerVp.setAdapter(vpBannerAdapter);

        bannerIndicator.setBannerImagesize(newsBean.size());

        bannerIndicator.setCurrentBannerItem(0);
        bannerVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                banner_item = position;
                bannerIndicator.setCurrentBannerItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
