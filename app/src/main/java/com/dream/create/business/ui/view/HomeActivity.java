package com.dream.create.business.ui.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dream.create.R;
import com.dream.create.business.ui.adapter.HomeListAdapter;
import com.dream.create.business.ui.entity.HomeListItemEntity;
import com.dream.create.databinding.ActivityHomeBinding;
import com.dream.create.framework.BaseActivity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class HomeActivity extends BaseActivity {
    private ActivityHomeBinding mActivityHomeBinding;
    private RecyclerView mRecyclerviewHome;
    private HomeListAdapter mHomeListAdapter;
    private List<HomeListItemEntity> mList = new ArrayList<>();
    private ActivityResultLauncher mLauncher;
    private String TAG = "HomeActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mActivityHomeBinding.getRoot());
        initView();
        initData();
        initLauncher();
    }

    private void initView(){
        initToolbar();
        mHomeListAdapter = new HomeListAdapter(R.layout.item_home_main_list_layout,mList);
        initAdapter();
        mActivityHomeBinding.recyclerviewHome.setAdapter(mHomeListAdapter);
        mActivityHomeBinding.recyclerviewHome.setLayoutManager(new LinearLayoutManager(this));
        mActivityHomeBinding.fabEditHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAddComment();
            }
        });
    }

    public void initAdapter() {
        mActivityHomeBinding.srlHome.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mActivityHomeBinding.recyclerviewHome.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        HomeListItemEntity e = new HomeListItemEntity();
                        e.setSingleText("sad");
                        mList.add(e);
                        mHomeListAdapter.notifyDataSetChanged();
                        mActivityHomeBinding.srlHome.finishLoadmore();
                    }
                },2000);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mActivityHomeBinding.recyclerviewHome.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        HomeListItemEntity e = new HomeListItemEntity();
                        e.setSingleText("sad");
                        mList.add(e);
                        mHomeListAdapter.notifyDataSetChanged();
                        mActivityHomeBinding.srlHome.finishRefresh();
                    }
                },2000);
            }
        });
    }

    public void initToolbar(){
        Toolbar tl_head = mActivityHomeBinding.tlHome;
        // 设置工具栏左边的导航图标
        // 设置工具栏的标题文本
        tl_head.setTitle(R.string.str_title_toolbar_home);
        // 设置工具栏的标题文字颜色
        tl_head.setTitleTextColor(Color.BLUE);
        // 设置工具栏的标题文字风格
//        tl_head.setTitleTextAppearance(this, R.style.TabButton);
        // 设置工具栏的标志图片
//        tl_head.setLogo(R.mipmap.ic_launcher);
        // 设置工具栏的副标题文本
//        tl_head.setSubtitle("Toolbar");
        // 设置工具栏的副标题文字颜色
        tl_head.setSubtitleTextColor(Color.YELLOW);
        // 设置工具栏的背景
        tl_head.setBackgroundResource(R.color.design_default_color_on_primary);
        // 使用tl_head替换系统自带的ActionBar
        setSupportActionBar(tl_head);
    }

    private void initData(){
        for (int i = 0; i < 30; i++) {
            HomeListItemEntity entity = new HomeListItemEntity();
            entity.setSingleText("item " + i);
            mList.add(entity);
        }
        mHomeListAdapter.notifyDataSetChanged();
    }

    public void initLauncher(){
        mLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Optional.ofNullable(result.getData()).ifPresent(intent -> {
                String comment = intent.getStringExtra("comment");
                HomeListItemEntity entity = new HomeListItemEntity();
                entity.setSingleText(comment);
                mList.add(entity);
                mHomeListAdapter.notifyItemInserted(mList.size() - 1);
            });
        });
    }

    public void goAddComment(){
        Intent t = new Intent(HomeActivity.this,AddCommentActivity.class);
        Optional.ofNullable(t).ifPresent(new Consumer<Intent>() {
            @Override
            public void accept(Intent intent) {
                mLauncher.launch(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
