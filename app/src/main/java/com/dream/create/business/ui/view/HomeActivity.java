package com.dream.create.business.ui.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dream.create.R;
import com.dream.create.business.ui.adapter.HomeListAdapter;
import com.dream.create.business.ui.entity.HomeListItemEntity;
import com.dream.create.databinding.ActivityHomeBinding;
import com.dream.create.framework.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {
    private ActivityHomeBinding mActivityHomeBinding;
    private RecyclerView mRecyclerviewHome;
    private HomeListAdapter mHomeListAdapter;
    private List<HomeListItemEntity> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mActivityHomeBinding.getRoot());
        initView();
        initData();
        mHomeListAdapter = new HomeListAdapter(R.layout.item_home_main_list_layout,mList);
        mActivityHomeBinding.recyclerviewHome.setAdapter(mHomeListAdapter);
        mActivityHomeBinding.recyclerviewHome.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initView(){
        mActivityHomeBinding.fabEditHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initData(){
        mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            HomeListItemEntity entity = new HomeListItemEntity();
            entity.setSingleText("item " + i);
            mList.add(entity);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
