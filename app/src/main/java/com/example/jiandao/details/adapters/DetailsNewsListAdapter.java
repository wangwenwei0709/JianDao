package com.example.jiandao.details.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jiandao.R;
import com.example.jiandao.details.bean.DetailsBean;

import java.util.List;

public class DetailsNewsListAdapter extends RecyclerView.Adapter<DetailsNewsListAdapter.ViewHolder> {
    private Context context;
    private List<DetailsBean.DataBean.AccessArticleListBean> accessArticleListBeans;

    public DetailsNewsListAdapter(Context context, List<DetailsBean.DataBean.AccessArticleListBean> accessArticleListBeans) {
        this.context = context;
        this.accessArticleListBeans = accessArticleListBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.two,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(accessArticleListBeans.get(position).getImage_url()).into(holder.iv);
        holder.tv.setText(accessArticleListBeans.get(position).getTheme());
        holder.tv2.setText(accessArticleListBeans.get(position).getColumn_name());
    }

    @Override
    public int getItemCount() {
        return accessArticleListBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        private TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_two);
            tv = itemView.findViewById(R.id.tv_two);
            tv2 = itemView.findViewById(R.id.tv2_two);
        }
    }
}
