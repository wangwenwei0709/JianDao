package com.example.jiandao.home.model;

import com.example.jiandao.base.BaseModel;
import com.example.jiandao.home.contract.HomeContract;

public class HomeModelImpl extends BaseModel implements HomeContract.IHomeMOdel {

    private HomeContract.IHomePresenter iHomePresenter;

    public HomeModelImpl(HomeContract.IHomePresenter iHomePresenter){
        this.iHomePresenter = iHomePresenter;
    }

    @Override
    public void getHomeBannview() {
        iHomePresenter.callNomeBannview("uyfy");
    }
}
