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

public class AccommodationAdapter extends RecyclerView.Adapter<AccommodationAdapter.ViewHolder> {

    private Context context;
    private List<AccommodationItem> accommodationList;

    public AccommodationAdapter(Context context, List<AccommodationItem> accommodationList) {
        this.context = context;
        this.accommodationList = accommodationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_accommodation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (accommodationList.size() > 0) {
            AccommodationItem item = accommodationList.get(position);
            holder.tvTitle.setText(item.getTitle());
            holder.tvPrice.setText(item.getPrice());
            Glide.with(context).load(item.getImageResId()).into(holder.ivImage);
        }
    }

    @Override
    public int getItemCount() {
        return accommodationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvTitle;
        TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}