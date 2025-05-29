
package com.example.travelapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

        // 初始化发现列表（重点修改这里）
        lvDiscovery = view.findViewById(R.id.lv_discovery);
        setupDiscoveryList();

        return view;
    }

    private void setupNewsList() {
        // 原有新闻列表逻辑不变
        List<Map<String, Object>> newsList = new ArrayList<>();
        int[] imageIds = {R.drawable.news_image1, R.drawable.news_image2, R.drawable.news_image3};
        String[] newsTitles = {"旅游新闻1", "旅游新闻2", "旅游新闻3"};

        for (int i = 0; i < newsTitles.length; i++) {
            Map<String, Object> newsItem = new HashMap<>();
            newsItem.put("image", imageIds[i]);
            newsItem.put("title", newsTitles[i]);
            newsList.add(newsItem);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                newsList,
                R.layout.item_news,
                new String[]{"image", "title"},
                new int[]{R.id.iv_news_image, R.id.tv_news_title}
        );
        lvNews.setAdapter(adapter);
    }

    private void setupDiscoveryList() {
        // 从 strings.xml 中获取数据
        String[] discoveryItems = getResources().getStringArray(R.array.discovery_items);

        // 创建 ArrayAdapter（使用系统默认列表项布局）
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1, // 系统默认文本布局
                android.R.id.text1,
                discoveryItems
        );

        // 设置适配器
        lvDiscovery.setAdapter(adapter);

        // 可选：添加列表项点击事件
        lvDiscovery.setOnItemClickListener((parent, view, position, id) -> {
            String item = discoveryItems[position];
            // 处理点击事件（例如Toast提示）
            android.widget.Toast.makeText(getActivity(), "点击了：" + item, android.widget.Toast.LENGTH_SHORT).show();
        });
    }

    private void setupViewPager() {
        // 原有ViewPager逻辑不变
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        adapter.addFragment(new ViewPagerFragment("热门景点"));
        adapter.addFragment(new ViewPagerFragment("美食推荐"));
        adapter.addFragment(new ViewPagerFragment("特色住宿"));
        adapter.addFragment(new ViewPagerFragment("旅游攻略"));
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0: tab.setText("热门景点"); break;
                case 1: tab.setText("美食推荐"); break;
                case 2: tab.setText("特色住宿"); break;
                case 3: tab.setText("旅游攻略"); break;
            }
        }).attach();
    }

    // ViewPager适配器不变
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