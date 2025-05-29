package com.example.travelapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ViewPagerFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private String title;

    public ViewPagerFragment() {
        // 空构造函数
    }

    public ViewPagerFragment(String title) {
        this.title = title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        // 设置标题
        TextView tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText(title);

        // 设置图片
        ImageView ivContentImage = view.findViewById(R.id.iv_content_image);
        int imageResource = getImageResourceForTitle(title);
        ivContentImage.setImageResource(imageResource);

        return view;
    }

    private int getImageResourceForTitle(String title) {
        switch (title) {
            case "热门景点":
                return R.drawable.attraction_image; // 替换为实际的热门景点图片资源
            case "美食推荐":
                return R.drawable.food_image; // 替换为实际的美食图片资源
            case "特色住宿":
                return R.drawable.accommodation_image; // 替换为实际的住宿图片资源
            case "旅游攻略":
                return R.drawable.strategy_image; // 替换为实际的旅游攻略图片资源
            default:
                return R.mipmap.ic_launcher;
        }
    }
}