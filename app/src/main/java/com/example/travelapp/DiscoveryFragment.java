package com.example.travelapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscoveryFragment extends Fragment {

    private ListView lvNews, lvDiscovery;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discovery, container, false);

        // 初始化新闻列表
        lvNews = view.findViewById(R.id.lv_news);
        setupNewsList();

        // 初始化ViewPager
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        setupViewPager();

        // 初始化原有的发现列表
        lvDiscovery = view.findViewById(R.id.lv_discovery);
        setupDiscoveryList();

        return view;
    }

    private void setupNewsList() {
        // 新闻列表逻辑保持不变
        // ...
    }

    private void setupViewPager() {
        // 创建适配器
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);

        // 添加四个页面
        adapter.addFragment(new ViewPagerFragment("热门景点"));
        adapter.addFragment(new ViewPagerFragment("美食推荐"));
        adapter.addFragment(new ViewPagerFragment("特色住宿"));
        adapter.addFragment(new ViewPagerFragment("旅游攻略"));

        // 设置适配器
        viewPager.setAdapter(adapter);

        // 配置指示器
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        // 设置标签文本
                        switch (position) {
                            case 0:
                                tab.setText("热门景点");
                                break;
                            case 1:
                                tab.setText("美食推荐");
                                break;
                            case 2:
                                tab.setText("特色住宿");
                                break;
                            case 3:
                                tab.setText("旅游攻略");
                                break;
                        }
                    }
                }
        ).attach();
    }

    private void setupDiscoveryList() {
        // 原有发现列表的设置逻辑保持不变
        // ...
    }

    // ViewPager适配器
    private static class ViewPagerAdapter extends FragmentStateAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();

        public ViewPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        public void addFragment(Fragment fragment) {
            fragmentList.add(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentList.size();
        }
    }
}