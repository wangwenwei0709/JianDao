package com.example.jiandao.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseActivity;
import com.example.jiandao.base.BaseFragment;
import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.home.contract.HomeContract;
import com.example.jiandao.home.presenter.HomePresenterImpl;
import com.example.jiandao.home.view.fragment.MeFragment;
import com.example.jiandao.home.view.fragment.RecommendFragment;
import com.example.jiandao.home.view.fragment.SpecialFragment;
import com.example.jiandao.home.view.fragment.VideoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeContract.IHomeView {


    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private FragmentManager supportFragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RecommendFragment recommendFragment;
    private VideoFragment videoFragment;
    private SpecialFragment specialFragment;
    private MeFragment meFragment;

    @Override
    protected BasePresenter initPresenter() {
        return new HomePresenterImpl();
    }

    @Override
    public void initView() {
        tabLayout.addTab(tabLayout.newTab().setText("推荐").setIcon(R.drawable.se_recommend));
        tabLayout.addTab(tabLayout.newTab().setText("视频").setIcon(R.drawable.se_video));
        tabLayout.addTab(tabLayout.newTab().setText("专题").setIcon(R.drawable.se_special));
        tabLayout.addTab(tabLayout.newTab().setText("我").setIcon(R.drawable.se_mine));

        initFragmentReplace();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0){
                    getSupportFragmentManager().beginTransaction()
                    .show(recommendFragment).hide(videoFragment).hide(specialFragment).hide(meFragment).commit();
                }else if (position == 1){
                    getSupportFragmentManager().beginTransaction().show(videoFragment).hide(recommendFragment).hide(specialFragment).hide(meFragment).commit();
                }else if (position == 2){
                    getSupportFragmentManager().beginTransaction().show(specialFragment).hide(recommendFragment).hide(videoFragment).hide(meFragment).commit();
                }else if (position == 3){
                    getSupportFragmentManager().beginTransaction().show(meFragment).hide(recommendFragment).hide(videoFragment).hide(specialFragment).commit();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initFragmentReplace() {
        supportFragmentManager = getSupportFragmentManager();
        fragmentTransaction = supportFragmentManager.beginTransaction();
        recommendFragment = new RecommendFragment();
        videoFragment = new VideoFragment();
        specialFragment = new SpecialFragment();
        meFragment = new MeFragment();
        fragmentTransaction.add(R.id.fl, recommendFragment).show(recommendFragment);
        fragmentTransaction.add(R.id.fl, videoFragment).hide(videoFragment);
        fragmentTransaction.add(R.id.fl, specialFragment).hide(specialFragment);
        fragmentTransaction.add(R.id.fl, meFragment).hide(meFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    public void setBannView(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


}
