package com.example.jiandao.special;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
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
import com.example.jiandao.vp.Banner_Indicator;
import com.example.jiandao.vp.NewsBean;
import com.example.jiandao.vp.VpBannerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.jzvd.JZVideoPlayerStandard;

public class SpecialRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private SpecialBean specialBean;
    private Activity context;
    private int ONE_TYPE=1;//banner
    private int TWO_TYPE=2;//小图
    private OneViewHolder oneViewHolder;
    private Timer timer;
    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public SpecialRvAdapter(SpecialBean specialBean, Activity context) {
        this.specialBean = specialBean;
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
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==ONE_TYPE){
            OneViewHolder oneViewHolder = (OneViewHolder) holder;
            this.oneViewHolder = oneViewHolder;
            initBanner(specialBean,oneViewHolder);
        }else if (itemViewType==TWO_TYPE){
            TwoViewHolder twoViewHolder= (TwoViewHolder) holder;
            twoViewHolder.tv.setText(specialBean.getData().getList().get(position).getTheme());
            twoViewHolder.tv2.setText(specialBean.getData().getList().get(position).getColumn_name());
            Glide.with(context).load(specialBean.getData().getList().get(position).getImage_url()).into(twoViewHolder.iv);
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
        } else {
            return TWO_TYPE;
        }
    }

    @Override
    public int getItemCount() {
        return specialBean.getData().getList().size()+1;
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

    private class OneViewHolder extends RecyclerView.ViewHolder {
        private ViewPager bannerVp;
        private Banner_Indicator bannerIndicator;
        public OneViewHolder(View view) {
            super(view);
            bannerVp = view.findViewById(R.id.one_vp);
            bannerIndicator = view.findViewById(R.id.one_indicator);
        }
    }


    int banner_item;
    int viewpage_Current_Pos = 0;
    private List<View> banner_views = new ArrayList<>();

    private void initBanner(SpecialBean newsBean,OneViewHolder oneViewHolder) {
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
                    SpecialBean.DataBean.BannerListBean bannerListBean = newsBean.getData().getBanner_list().get(banner_item);
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
                        oneViewHolder.bannerVp.setCurrentItem(viewpage_Current_Pos%(specialBean.getData().getBanner_list().size()));
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
