package com.example.jiandao.home.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseFragment;
import com.example.jiandao.login.LoginActivity;
import com.example.jiandao.me.MeFragmentContract;
import com.example.jiandao.me.MePresenter;

import butterknife.BindView;

public class MeFragment extends BaseFragment<MePresenter> implements MeFragmentContract.IMeView {

    @BindView(R.id.me_pic)
    ImageView mePic;
    @BindView(R.id.me_pic_tv1)
    TextView mePicTv1;
    @BindView(R.id.me_pic_tv2)
    TextView mePicTv2;
    @BindView(R.id.me_integral_image)
    ImageView meIntegralImage;
    @BindView(R.id.me_integral_tv)
    TextView meIntegralTv;
    @BindView(R.id.me_integral_image2)
    ImageView meIntegralImage2;
    @BindView(R.id.me_integral_tv2)
    TextView meIntegralTv2;
    @BindView(R.id.me_integral_image3)
    ImageView meIntegralImage3;
    @BindView(R.id.me_collect_image)
    ImageView meCollectImage;
    @BindView(R.id.me_collect_tv)
    TextView meCollectTv;
    @BindView(R.id.me_collect_image3)
    ImageView meCollectImage3;
    @BindView(R.id.me_mes_image)
    ImageView meMesImage;
    @BindView(R.id.me_mes_tv)
    TextView meMesTv;
    @BindView(R.id.me_mes_image3)
    ImageView meMesImage3;
    @BindView(R.id.me_set_image)
    ImageView meSetImage;
    @BindView(R.id.me_set_tv)
    TextView meSetTv;
    @BindView(R.id.me_set_image3)
    ImageView meSetImage3;
    @BindView(R.id.login_me)
    Button loginMe;

    public static MeFragment newInstance() {
        MeFragment meFragment = new MeFragment();
        return meFragment;
    }


    @Override
    protected MePresenter initPresenter() {
        return new MePresenter();
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initListener() {
        loginMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),LoginActivity.class));
            }
        });


    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}
