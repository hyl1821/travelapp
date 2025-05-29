//package com.example.travelapp;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import androidx.fragment.app.Fragment;
//
//
//
//public class CommunityFragment extends Fragment {
//
//    private ListView recyclerView;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//      View view = inflater.inflate(R.layout.fragment_community, container, false);
//
//
//        recyclerView = view.findViewById(R.id.recyclerView);
//        setuprecyclerList();
//
//        return view;
//    }
//
//    private void setuprecyclerList() {
//        // 从 strings.xml 中获取数据
//        String[] discoveryItems = getResources().getStringArray(R.array.recommend_items);
//
//        // 创建 ArrayAdapter（使用系统默认列表项布局）
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                getActivity(),
//                android.R.layout.simple_list_item_1, // 系统默认文本布局
//                android.R.id.text1,
//                discoveryItems
//        );
//
//        // 设置适配器
//        recyclerView.setAdapter(adapter);
//    }
//
//}
package com.example.travelapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class CommunityFragment extends Fragment {

    private ListView listRecommend, listHot, listLatest;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);

        // 初始化ListView
        listRecommend = view.findViewById(R.id.list_recommend);
        listHot = view.findViewById(R.id.list_hot);
        listLatest = view.findViewById(R.id.list_latest);
        tabLayout = view.findViewById(R.id.tabLayout);

        // 加载各列表数据
        loadRecommendData();
        loadHotData();
        loadLatestData();

        // 设置标签点击事件
        setupTabListener();

        return view;
    }

    private void loadRecommendData() {
        String[] items = getResources().getStringArray(R.array.recommend_items);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        );
        listRecommend.setAdapter(adapter);
    }

    private void loadHotData() {
        String[] items = getResources().getStringArray(R.array.hot_items);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        );
        listHot.setAdapter(adapter);
    }

    private void loadLatestData() {
        String[] items = getResources().getStringArray(R.array.latest_items);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        );
        listLatest.setAdapter(adapter);
    }

    private void setupTabListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 隐藏所有列表
                hideAllLists();
                // 显示当前标签对应的列表
                switch (tab.getPosition()) {
                    case 0:
                        listRecommend.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        listHot.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        listLatest.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // 标签未选中时不做处理
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // 标签重新选中时不做处理
            }
        });
    }

    private void hideAllLists() {
        listRecommend.setVisibility(View.GONE);
        listHot.setVisibility(View.GONE);
        listLatest.setVisibility(View.GONE);
    }
}
