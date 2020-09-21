package com.example.app2;

import java.util.List;

public interface NetView {
    void setData(List<ProjectBean.ResultsBean> resultsBeans);
    void showToast(String str);
}
