package com.dream.create.business.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dream.create.R;
import com.dream.create.business.ui.entity.HomeListItemEntity;

import java.util.List;

public class HomeListAdapter extends BaseQuickAdapter<HomeListItemEntity, BaseViewHolder> {
    public HomeListAdapter(int layoutResId, List<HomeListItemEntity> data) {
        super(layoutResId, data);
    }

    public HomeListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, HomeListItemEntity homeListItemEntity) {
        baseViewHolder.setText(R.id.tv_item_home_main_list,homeListItemEntity.getSingleText());
    }
}
