package com.example.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder> {
    private Context context;
    private List<RecommendItem> recommendList;

    public RecommendAdapter(Context context, List<RecommendItem> recommendList) {
        this.context = context;
        this.recommendList = recommendList;
    }

    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommend, parent, false);
        return new RecommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendViewHolder holder, int position) {
        RecommendItem item = recommendList.get(position);
        holder.tvTitle.setText(item.getTitle());
        Glide.with(context)
                .load(item.getImageResId())
                .placeholder(R.drawable.placeholder_image) // 占位图
                .error(R.drawable.error_image) // 错误图
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return recommendList.size();
    }

    public static class RecommendViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvTitle;

        public RecommendViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}