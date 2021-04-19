package com.dream.create.business.ui.view;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.dream.create.databinding.ActivityAddCommentLayoutBinding;
import com.dream.create.framework.BaseActivity;

public class AddCommentActivity extends BaseActivity {
    private ActivityAddCommentLayoutBinding mActivityAddCommentLayoutBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityAddCommentLayoutBinding = ActivityAddCommentLayoutBinding.inflate(getLayoutInflater());
        setContentView(mActivityAddCommentLayoutBinding.getRoot());

    }
}
