package com.example.jiandao.details.view;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseActivity;
import com.example.jiandao.details.adapters.CommentAdapter;
import com.example.jiandao.details.adapters.DetailsNewsListAdapter;
import com.example.jiandao.details.bean.CommentBean;
import com.example.jiandao.details.bean.DetailsBean;
import com.example.jiandao.details.contract.DetailsContract;
import com.example.jiandao.details.presenter.DetailsPresenter;
import com.example.jiandao.login.LoginActivity;
import com.example.jiandao.login.VerfiedBean;
import com.example.jiandao.utils.MyWebViewClient;
import com.example.jiandao.vp.NewsBean;
import com.tencent.mmkv.MMKV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DetailsActivity extends BaseActivity<DetailsPresenter> implements DetailsContract.IDetailsView ,MyWebViewClient.WebViewFinishedClieck{

    @BindView(R.id.web_details)
    WebView webDetails;
    @BindView(R.id.back_imag)
    ImageView backImag;
    @BindView(R.id.seach_detail)
    ImageView seachDetail;
    @BindView(R.id.awesome_detail)
    ImageView awesomeDetail;
    @BindView(R.id.collect_detail)
    ImageView collectDetail;
    @BindView(R.id.share_details)
    ImageView shareDetails;
    @BindView(R.id.title_details)
    ConstraintLayout titleDetails;
    @BindView(R.id.recycleview_details)
    RecyclerView recycleviewDetails;
    @BindView(R.id.comment_recycleview)
    RecyclerView commentRecycleview;

    private NewsBean.DataBean.ArticleListBean articlelist;
    List<DetailsBean.DataBean.AccessArticleListBean> access_article_list = new ArrayList<>();
    List<CommentBean.DataBean.CommentListBean> commentListBeanList = new ArrayList<>();
    private DetailsNewsListAdapter adapter;
    private CommentAdapter commentAdapter;

    @Override
    protected DetailsPresenter initPresenter() {
        return new DetailsPresenter();
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        articlelist = intent.getParcelableExtra("article");
        if (articlelist!=null){
            initWebView();


            int is_good = articlelist.getIs_good();
            int is_collect = articlelist.getIs_collect();
            if (is_good==1){
                awesomeDetail.setBackgroundResource(R.drawable.ic_news_detail_like);
            }else {
                awesomeDetail.setBackgroundResource(R.mipmap.ic_news_detail_like_no);
            }
            if (is_collect==1){
                collectDetail.setBackgroundResource(R.mipmap.ic_news_detail_collect);
            }else {
                collectDetail.setBackgroundResource(R.mipmap.ic_news_detail_collect_no);
            }

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recycleviewDetails.setLayoutManager(linearLayoutManager);
            adapter = new DetailsNewsListAdapter(this, access_article_list);
            recycleviewDetails.setAdapter(adapter);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            commentRecycleview.setLayoutManager(layoutManager);
            commentAdapter = new CommentAdapter(this, commentListBeanList);
            commentRecycleview.setAdapter(commentAdapter);


        }else {
            Toast.makeText(this, "文章有误", Toast.LENGTH_SHORT).show();
        }

    }

    private void initWebView() {
        WebSettings settings = webDetails.getSettings();
        settings.setJavaScriptEnabled(true);
        webDetails.setWebViewClient(new MyWebViewClient(this));
        webDetails.setWebChromeClient(new WebChromeClient(){});
        webDetails.loadUrl(articlelist.getLink());
    }


    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        awesomeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MMKV mmkv = MMKV.defaultMMKV();
                String token = mmkv.decodeString("token");
                if (TextUtils.isEmpty(token)){
                    Toast.makeText(DetailsActivity.this, "当前未登录,请先登录", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DetailsActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    mPresenter.like(articlelist.getId(),articlelist.getIs_good());
                }
            }
        });

        collectDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MMKV mmkv = MMKV.defaultMMKV();
                String token = mmkv.decodeString("token");
                if (TextUtils.isEmpty(token)){
                    Toast.makeText(DetailsActivity.this, "当前未登录,请先登录", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DetailsActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    mPresenter.collect(articlelist.getId(),articlelist.getIs_collect()==1 ? 2:1);
                }
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_details;
    }

    @Override
    public void getArticleDetails(DetailsBean detailsBean) {
        Log.e("TAG","关联列表："+detailsBean.toString());

        this.access_article_list.addAll(detailsBean.getData().getAccess_article_list());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void collect(VerfiedBean collectBean) {
        if (collectBean.getCode()==1){
            if (articlelist.getIs_collect()==1){
                Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT).show();
                articlelist.setIs_collect(0);
                collectDetail.setBackgroundResource(R.mipmap.ic_news_detail_collect_no);
            }else {
                Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
                articlelist.setIs_collect(1);
                collectDetail.setBackgroundResource(R.mipmap.ic_news_detail_collect);
            }
        }
    }

    @Override
    public void like(VerfiedBean collectBean) {
        if (collectBean.getCode()==1){
            if (articlelist.getIs_good()==1){
                Toast.makeText(this, "取消点赞", Toast.LENGTH_SHORT).show();
                articlelist.setIs_good(0);
                awesomeDetail.setBackgroundResource(R.mipmap.ic_news_detail_like_no);
            }else {
                Toast.makeText(this, "点赞成功", Toast.LENGTH_SHORT).show();
                articlelist.setIs_good(1);
                awesomeDetail.setBackgroundResource(R.mipmap.ic_news_detail_like);
            }
        }
    }

    @Override
    public void addUserIntegalResult(VerfiedBean collectBean) {

    }

    @Override
    public void getCommentList(CommentBean commentBean) {
        this.commentListBeanList.addAll(commentBean.getData().getComment_list());
        commentAdapter.notifyDataSetChanged();
    }

    public void backBut(View view) {
        finish();
    }


    @Override
    public void webViewFinished() {
        mPresenter.getArticleDetails(articlelist.getId());
        mPresenter.getCommentList(articlelist.getId(),"0","0");
    }
}
