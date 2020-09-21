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
import com.example.jiandao.details.bean.CommentBean;
import com.example.jiandao.witgth.CommentsView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private Context context;
    private List<CommentBean.DataBean.CommentListBean> commentListBeans;

    public CommentAdapter(Context context, List<CommentBean.DataBean.CommentListBean> commentListBeans) {
        this.context = context;
        this.commentListBeans = commentListBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.article_comment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(commentListBeans.get(position).getHead_url()).into(holder.collent_img);
        holder.collent_name.setText(commentListBeans.get(position).getUsername());
        holder.time.setText(commentListBeans.get(position).getTime_describe());
        holder.comment_content.setText(commentListBeans.get(position).getContent());
        holder.commentsView.setList(commentListBeans.get(position).getReply_list());
        holder.commentsView.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return commentListBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView collent_img;
        private TextView collent_name;
        private TextView time;
        private TextView comment_content;
        private CommentsView commentsView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            collent_img = itemView.findViewById(R.id.collent_img);
            collent_name = itemView.findViewById(R.id.collect_name);
            time = itemView.findViewById(R.id.time);
            comment_content = itemView.findViewById(R.id.comment_content);
            commentsView = itemView.findViewById(R.id.recomment_view);
        }
    }
}
