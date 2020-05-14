package com.example.jiandao.vp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.jiandao.R;
import com.example.jiandao.details.view.DetailsActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.jzvd.JZVideoPlayerStandard;

public class VpRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private NewsBean newsBeans;
    private Activity context;
    private int ONE_TYPE=1;//banner
    private int TWO_TYPE=2;//小图
    private int THREE_TYPE=3;//大图
    private int FOUR_TYPE=4;//视频
    private int FIVE_TYPE=5;//跑马灯
    private OneViewHolder oneViewHolder;
    private Timer timer;
    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public VpRvAdapter(NewsBean newsBeans, Activity context) {
        this.newsBeans = newsBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==ONE_TYPE){//banner
            View view = LayoutInflater.from(context).inflate(R.layout.one, parent, false);
            return new OneViewHolder(view);
        }else if (viewType==TWO_TYPE){//小图
            View view = LayoutInflater.from(context).inflate(R.layout.two,parent,false);
            return new TwoViewHolder(view);
        }else if (viewType==THREE_TYPE){//大图
            View view = LayoutInflater.from(context).inflate(R.layout.three, parent,false);
            return new ThreeViewHolder(view);
        }else if (viewType==FOUR_TYPE){//视频
            View view = LayoutInflater.from(context).inflate(R.layout.four, parent,false);
            return new FourViewHolder(view);
        }else if (viewType==FIVE_TYPE){//跑马灯
            View view = LayoutInflater.from(context).inflate(R.layout.five, parent,false);
            return new FiveViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==ONE_TYPE){
            OneViewHolder oneViewHolder = (OneViewHolder) holder;
            this.oneViewHolder = oneViewHolder;
            initBanner(newsBeans,oneViewHolder);
        }else if (itemViewType==TWO_TYPE){
            TwoViewHolder twoViewHolder= (TwoViewHolder) holder;
            twoViewHolder.tv.setText(newsBeans.getData().getArticle_list().get(position).getTheme());
            twoViewHolder.tv2.setText(newsBeans.getData().getArticle_list().get(position).getColumn_name());
            Glide.with(context).load(newsBeans.getData().getArticle_list().get(position).getImage_url()).into(twoViewHolder.iv);
        }else if (itemViewType==THREE_TYPE){
            ThreeViewHolder threeViewHolder= (ThreeViewHolder) holder;
            threeViewHolder.tv.setText(newsBeans.getData().getArticle_list().get(position).getTheme());
            threeViewHolder.tv2.setText(newsBeans.getData().getArticle_list().get(position).getColumn_name());
            Glide.with(context).load(newsBeans.getData().getArticle_list().get(position).getImage_url()).into(threeViewHolder.iv);
        }else if (itemViewType==FOUR_TYPE){
            FourViewHolder fourViewHolder= (FourViewHolder) holder;
            fourViewHolder.tv.setText(newsBeans.getData().getArticle_list().get(position).getTheme());
            fourViewHolder.tv2.setText(newsBeans.getData().getArticle_list().get(position).getColumn_name());
            fourViewHolder.jz.setUp(newsBeans.getData().getArticle_list().get(position).getVideo_url(),JZVideoPlayerStandard.SCROLL_AXIS_HORIZONTAL,newsBeans.getData().getArticle_list().get(position).getTheme());
            Glide.with(context).load(newsBeans.getData().getArticle_list().get(position).getImage_url()).into(fourViewHolder.jz.thumbImageView);
        }else if (itemViewType==FIVE_TYPE){
            FiveViewHolder fiveViewHolder = (FiveViewHolder) holder;
            List<NewsBean.DataBean.FlashListBean> flash_list = newsBeans.getData().getFlash_list();
            String a="";
            for (int i = 0; i < flash_list.size(); i++) {
                a=a+flash_list.get(i).getTheme()+"   ";
                i++;
            }
            fiveViewHolder.tv.setText(a);
            SpannableString spannableString = new SpannableString(a);
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Toast.makeText(context, "i", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    ds.setUnderlineText(false);
                }
            };
            spannableString.setSpan(clickableSpan,0,1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//            fiveViewHolder.tv.setMovementMethod(LinkMovementMethod.getInstance());
//            fiveViewHolder.tv.setText(spannableString);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(position);
            }
        });
    }

    public interface OnItemClick{
        void onClick(int position);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return ONE_TYPE;
        }
        if (null !=newsBeans.getData().getFlash_list() && newsBeans.getData().getFlash_list().size()>0 && position==1){
            return FIVE_TYPE;
        }
        if (newsBeans.getData().getArticle_list().get(position).getView_type()==2){
            return THREE_TYPE;
        }else if (newsBeans.getData().getArticle_list().get(position).getView_type()==4){
            return FOUR_TYPE;
        }else {
            return TWO_TYPE;
        }
    }

    @Override
    public int getItemCount() {
        return (null !=newsBeans.getData().getFlash_list() && newsBeans.getData().getFlash_list().size()>0)?newsBeans.getData().getArticle_list().size()+2:newsBeans.getData().getArticle_list().size()+1;
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

    private class OneViewHolder extends RecyclerView.ViewHolder {
        private ViewPager bannerVp;
        private Banner_Indicator bannerIndicator;
        public OneViewHolder(View view) {
            super(view);
            bannerVp = view.findViewById(R.id.one_vp);
            bannerIndicator = view.findViewById(R.id.one_indicator);
        }
    }

    private class FiveViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public FiveViewHolder(View view) {
            super(view);
            tv = view.findViewById(R.id.tv_five);
        }
    }

    int banner_item;
    int viewpage_Current_Pos = 0;
    private List<View> banner_views = new ArrayList<>();

    private void initBanner(NewsBean newsBean,OneViewHolder oneViewHolder) {
        for (int i = 0; i < newsBean.getData().getBanner_list().size(); i++) {
            banner_item=i;
            View view = LayoutInflater.from(context).inflate(R.layout.vp_banner_item, null, false);
            ImageView bannerimage = view.findViewById(R.id.banner_image);
            TextView bannercontext = view.findViewById(R.id.banner_content);
            bannercontext.setText(newsBean.getData().getBanner_list().get(i).getTheme());
            Glide.with(context).load(newsBean.getData().getBanner_list().get(i).getImage_url()).into(bannerimage);
            banner_views.add(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewsBean.DataBean.BannerListBean bannerListBean = newsBean.getData().getBanner_list().get(banner_item);
                    String id = bannerListBean.getId();
                    String link = bannerListBean.getLink();
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("link",link);
                    context.startActivity(intent);
                }
            });
        }

        VpBannerAdapter vpBannerAdapter = new VpBannerAdapter(banner_views);
        oneViewHolder.bannerVp.setAdapter(vpBannerAdapter);

        oneViewHolder.bannerIndicator.setBannerImagesize(newsBean.getData().getBanner_list().size());

        oneViewHolder.bannerIndicator.setCurrentBannerItem(0);
        oneViewHolder.bannerVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                banner_item = position;
                oneViewHolder.bannerIndicator.setCurrentBannerItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initTimer();
    }

    private void initTimer() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewpage_Current_Pos+=1;
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        oneViewHolder.bannerVp.setCurrentItem(viewpage_Current_Pos%(newsBeans.getData().getBanner_list().size()));
                    }
                });
            }
        };
        timer.schedule(timerTask,2000,2000);
    }

    public  void isCurrentVisibleToUser(boolean isVisible){


        if (isVisible){
            initTimer();
        }else {
            timer.cancel();
        }

    }
}
