package com.example.jiandao.home.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.home.contract.HomeContract;
import com.example.jiandao.home.model.HomeModelImpl;
import com.example.jiandao.home.view.HomeActivity;

public class HomePresenterImpl extends BasePresenter<HomeActivity> implements HomeContract.IHomePresenter {

    private HomeContract.IHomeMOdel iHomeMOdel;

    public HomePresenterImpl(){
        iHomeMOdel = new HomeModelImpl(this);
    }
    @Override
    public void callNomeBannview(String s) {
        mview.setBannView(s);
    }

    @Override
    public void getBannerView() {
        iHomeMOdel.getHomeBannview();
    }
}
