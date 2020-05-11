package com.example.jiandao.video;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jiandao.R;
import com.example.jiandao.vp.NewsBean;

import cn.jzvd.JZVideoPlayerStandard;

public class VideoFragmentRvAdapter extends RecyclerView.Adapter<VideoFragmentRvAdapter.ViewHolder> {
    private VideoFragmentBean videoFragmentBean;
    private Activity context;

    public VideoFragmentRvAdapter(VideoFragmentBean videoFragmentBean, Activity context) {
        this.videoFragmentBean = videoFragmentBean;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(videoFragmentBean.getData().getList().get(position).getTheme());
        holder.tv2.setText(videoFragmentBean.getData().getList().get(position).getLead());
        holder.jz.setUp(videoFragmentBean.getData().getList().get(position).getVideo_url(),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL);
        holder.jz.positionInList= position;
        Glide.with(context).load(videoFragmentBean.getData().getList().get(position).getImage_url()).into(holder.jz.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return videoFragmentBean.getData().getList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private JZVideoPlayerStandard jz;
        private TextView tv;
        private TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jz = itemView.findViewById(R.id.video_four);
            tv = itemView.findViewById(R.id.tv_four);
            tv2 = itemView.findViewById(R.id.tv2_four);
        }
    }
}
