package com.dream.create.business.ui.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dream.create.R;
import com.dream.create.business.ui.adapter.HomeListAdapter;
import com.dream.create.business.ui.entity.HomeListItemEntity;
import com.dream.create.framework.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {
    private RecyclerView mRecyclerviewHome;
    private HomeListAdapter mHomeListAdapter;
    private List<HomeListItemEntity> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
        mHomeListAdapter = new HomeListAdapter(R.layout.item_home_main_list_layout,mList);
        mRecyclerviewHome.setAdapter(mHomeListAdapter);
        mRecyclerviewHome.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initView(){
        mRecyclerviewHome = findViewById(R.id.recyclerview_home);
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
