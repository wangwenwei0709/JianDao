package com.example.jiandao.details.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseActivity;
import com.example.jiandao.details.bean.ArticleAttributeBean;
import com.example.jiandao.details.bean.CollectBean;
import com.example.jiandao.details.bean.DetailsBean;
import com.example.jiandao.details.contract.DetailsContract;
import com.example.jiandao.details.presenter.DetailsPresenter;
import com.example.jiandao.login.VerfiedBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity<DetailsPresenter> implements DetailsContract.IDetailsView {


    @BindView(R.id.web_details)
    WebView webDetails;
    @BindView(R.id.toolbar_details)
    Toolbar toolbarDetails;
    private String id;
    private String link;
    private String is_collect;
    private String is_good;

    @Override
    protected DetailsPresenter initPresenter() {
        return new DetailsPresenter();
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        link = intent.getStringExtra("link");

        toolbarDetails.setTitle("");
        setSupportActionBar(toolbarDetails);


    }


    @Override
    public void initData() {
        mPresenter.getarticleattribute(id,"e740386ba5430a6ab492e29ef50706f0");
    }

    @Override
    public void initListener() {
        webDetails.loadUrl(link);
        webDetails.setWebViewClient(new WebViewClient());
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_details;
    }

    @Override
    public void getArticleDetails(DetailsBean detailsBean) {

    }

    @Override
    public void collect(CollectBean collectBean) {

    }

    @Override
    public void getarticleattribute(ArticleAttributeBean articleAttributeBean) {
        is_collect = articleAttributeBean.getData().getIs_collect();
        is_good = articleAttributeBean.getData().getIs_good();
        if (is_collect.equals("0")){

        }else {

        }
        if (is_good.equals("0")){

        }else {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.i1:
                item.setChecked(true);
                item.setIcon(R.drawable.collect_black);
                mPresenter.collect(id,"1","2409dfc80ab96aa0b23da6e3923a049f");
            break;
            case R.id.i2:
                Toast.makeText(this, "点赞", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i3:
                Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i4:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
