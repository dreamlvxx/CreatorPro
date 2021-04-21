package com.dream.create.business.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dream.create.R;
import com.dream.create.business.ui.entity.HomeListEntity;

import java.util.List;

public class HomeListAdapter extends BaseQuickAdapter<HomeListEntity.Item, BaseViewHolder> {


    public HomeListAdapter(int layoutResId, @Nullable List<HomeListEntity.Item> data) {
        super(layoutResId, data);
    }

    public HomeListAdapter(@Nullable List<HomeListEntity.Item> data) {
        super(data);
    }

    public HomeListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HomeListEntity.Item item) {
        helper.setText(R.id.tv_item_home_main_list, item.name);
    }


}
