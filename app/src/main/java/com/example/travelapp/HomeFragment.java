package com.example.travelapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rvRecommend, rvAttractions, rvFood, rvAccommodation;
    private RecommendAdapter recommendAdapter;
    private AttractionAdapter attractionAdapter;
    private FoodAdapter foodAdapter;
    private AccommodationAdapter accommodationAdapter;
    private List<RecommendItem> recommendList;
    private List<AttractionItem> attractionList;
    private List<FoodItem> foodList;
    private List<AccommodationItem> accommodationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 初始化推荐RecyclerView
        rvRecommend = view.findViewById(R.id.rv_recommend);
        rvRecommend.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recommendList = new ArrayList<>();
        recommendAdapter = new RecommendAdapter(getActivity(), recommendList);
        rvRecommend.setAdapter(recommendAdapter);
        initRecommendData();

        // 初始化热门景点RecyclerView
        rvAttractions = view.findViewById(R.id.rv_attractions);
        rvAttractions.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        attractionList = new ArrayList<>();
        attractionAdapter = new AttractionAdapter(getActivity(), attractionList);
        rvAttractions.setAdapter(attractionAdapter);
        initAttractionData();

        // 初始化美食RecyclerView
        rvFood = view.findViewById(R.id.rv_food);
        rvFood.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        foodList = new ArrayList<>();
        foodAdapter = new FoodAdapter(getActivity(), foodList);
        rvFood.setAdapter(foodAdapter);
        initFoodData();

        // 初始化住宿RecyclerView
        rvAccommodation = view.findViewById(R.id.rv_accommodation);
        rvAccommodation.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        accommodationList = new ArrayList<>();
        accommodationAdapter = new AccommodationAdapter(getActivity(), accommodationList);
        rvAccommodation.setAdapter(accommodationAdapter);
        initAccommodationData();

        return view;
    }

    private void initRecommendData() {
        // 添加推荐数据，使用本地 drawable 资源
        recommendList.add(new RecommendItem(R.drawable.image1, "推荐景点1"));
        recommendList.add(new RecommendItem(R.drawable.image2, "推荐景点2"));
        recommendList.add(new RecommendItem(R.drawable.image3, "推荐景点3"));
        recommendList.add(new RecommendItem(R.drawable.image4, "推荐景点4"));
        recommendAdapter.notifyDataSetChanged();
    }

    private void initAttractionData() {
        // 添加更多景点数据
        attractionList.add(new AttractionItem(R.drawable.attraction1, "故宫博物院", "北京"));
        attractionList.add(new AttractionItem(R.drawable.attraction2, "西湖", "杭州"));
        attractionList.add(new AttractionItem(R.drawable.attraction_image, "张家界", "湖南"));
        attractionAdapter.notifyDataSetChanged();
    }

    private void initFoodData() {
        // 添加更多美食数据
        foodList.add(new FoodItem(R.drawable.food1, "北京烤鸭", "4.8分"));
        foodList.add(new FoodItem(R.drawable.food2, "小笼包", "4.7分"));
        foodList.add(new FoodItem(R.drawable.food, "重庆火锅", "4.9分"));
        foodAdapter.notifyDataSetChanged();
    }

    private void initAccommodationData() {
        // 添加更多住宿数据
        accommodationList.add(new AccommodationItem(R.drawable.accommodation_image, "豪华酒店", "¥888/晚"));
        accommodationList.add(new AccommodationItem(R.drawable.accommodation2, "特色民宿", "¥388/晚"));
        accommodationList.add(new AccommodationItem(R.drawable.accommodation1, "海景公寓", "¥588/晚"));
        accommodationAdapter.notifyDataSetChanged();
    }
}