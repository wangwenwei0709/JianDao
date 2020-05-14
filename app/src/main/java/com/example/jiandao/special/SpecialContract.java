package com.example.jiandao.special;

import com.example.jiandao.base.BaseView;
import com.example.jiandao.net.INetCallBack;
import com.example.jiandao.video.VideoFragmentBean;

public class SpecialContract {
    public interface ISpecialFragmentView extends BaseView {
        void  setSpecialList(SpecialBean specialBean);
    }
    public interface ISpecialFragmentMode{
        <T> void getSpecialList(INetCallBack<T> iNetCallBack);
    }
    public interface ISpecialFragmentPresenter{
        void getSpecialList();
    }
}
