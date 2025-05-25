package com.example.travelapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        // 这里可以根据不同的标题加载不同的内容
        // ...

        return view;
    }
}