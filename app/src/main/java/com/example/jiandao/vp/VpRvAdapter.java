package com.example.jiandao.vp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jiandao.R;
import com.example.jiandao.recommend.GlideImageLoader;
import com.example.jiandao.vp.NewsBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;
import retrofit2.http.POST;

public class VpRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<NewsBean.DataBean.ArticleListBean> newsBeans;
    private Context context;
    private int TWO_TYPE=2;
    private int THREE_TYPE=3;
    private int FOUR_TYPE=4;

    public VpRvAdapter(ArrayList<NewsBean.DataBean.ArticleListBean> newsBeans, Context context) {
        this.newsBeans = newsBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==TWO_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.two, null);
            return new TwoViewHolder(view);
        }else if (viewType==THREE_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.three, null);
            return new ThreeViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.four, null);
            return new FourViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        NewsBean.DataBean.ArticleListBean articleListBean = newsBeans.get(position);
        if (itemViewType==TWO_TYPE){
            TwoViewHolder twoViewHolder= (TwoViewHolder) holder;
            twoViewHolder.tv.setText(articleListBean.getTheme());
            twoViewHolder.tv2.setText(articleListBean.getColumn_name());
            Glide.with(context).load(articleListBean.getImage_url()).into(twoViewHolder.iv);
        }else if (itemViewType==THREE_TYPE){
            ThreeViewHolder threeViewHolder= (ThreeViewHolder) holder;
            threeViewHolder.tv.setText(articleListBean.getTheme());
            threeViewHolder.tv2.setText(articleListBean.getColumn_name());
            Glide.with(context).load(articleListBean.getImage_url()).into(threeViewHolder.iv);
        }else if (itemViewType==FOUR_TYPE){
            FourViewHolder fourViewHolder= (FourViewHolder) holder;
            fourViewHolder.tv.setText(articleListBean.getTheme());
            fourViewHolder.tv2.setText(articleListBean.getColumn_name());
            fourViewHolder.jz.setUp(articleListBean.getVideo_url(),JZVideoPlayerStandard.SCROLL_AXIS_HORIZONTAL,articleListBean.getTheme());
            Glide.with(context).load(articleListBean.getImage_url()).into(fourViewHolder.jz.thumbImageView);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (newsBeans.get(position).getView_type()==1){
            return TWO_TYPE;
        }else if (newsBeans.get(position).getView_type()==2){
            return THREE_TYPE;
        }else {
            return FOUR_TYPE;
        }
    }

    @Override
    public int getItemCount() {
        return newsBeans.size();
    }


    private class TwoViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        private TextView tv2;
        public TwoViewHolder(View view) {
            super(view);
            iv = view.findViewById(R.id.iv_two);
            tv = view.findViewById(R.id.tv_two);
            tv2 = view.findViewById(R.id.tv2_two);

        }
    }

    private class ThreeViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        private TextView tv2;
        public ThreeViewHolder(View view) {
            super(view);
            iv = view.findViewById(R.id.iv_three);
            tv = view.findViewById(R.id.tv_three);
            tv2 = view.findViewById(R.id.tv2_three);
        }
    }

    private class FourViewHolder extends RecyclerView.ViewHolder {
        private JZVideoPlayerStandard jz;
        private TextView tv;
        private TextView tv2;
        public FourViewHolder(View view) {
            super(view);
            jz = view.findViewById(R.id.video_four);
            tv = view.findViewById(R.id.tv_four);
            tv2 = view.findViewById(R.id.tv2_four);
        }
    }
}
