package com.example.jiandao.home.contract;

public class HomeContract {

    public interface IHomeView{
        void setBannView(String s);
    }

    public interface IHomeMOdel{
        void getHomeBannview();
    }

    public interface IHomePresenter{
        void callNomeBannview(String s);
        void getBannerView();
    }
}
