package com.example.app2;

public class NetPresenter implements NetCallback{
    private NetView netView;
    private NetModel netModel;

    public NetPresenter(NetView netView) {
        this.netView = netView;
        netModel = new NetModel();
    }

    @Override
    public void onSuccess(ProjectBean projectBean) {
        netView.setData(projectBean.getResults());
    }

    @Override
    public void onFaile(String s) {
        netView.showToast(s);
    }

    public void getData() {
        netModel.getData(this);
    }
}
