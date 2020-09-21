package com.example.app2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetView{


    private Toolbar mTab;
    private RecyclerView mRv;
    private ArrayList<ProjectBean.ResultsBean> objects;
    private RvAdapter rvAdapter;
    private NetPresenter netPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        netPresenter = new NetPresenter(this);
        netPresenter.getData();

    }

    private void initView() {
        mTab = (Toolbar) findViewById(R.id.tab);
        mRv = (RecyclerView) findViewById(R.id.rv);

        mTab.setTitle("");
        setSupportActionBar(mTab);

        mRv.setLayoutManager(new LinearLayoutManager(this));
        objects = new ArrayList<>();
        rvAdapter = new RvAdapter(this, objects);
        mRv.setAdapter(rvAdapter);
    }

    @Override
    public void setData(List<ProjectBean.ResultsBean> resultsBeans) {
        objects.addAll(resultsBeans);
        rvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

}
