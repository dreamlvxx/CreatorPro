package com.dream.create.business.ui.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.dream.create.business.ui.view.HomeActivity;
import com.dream.create.framework.BaseActivity;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent t = new Intent(this, HomeActivity.class);
        startActivity(t);
    }
}
