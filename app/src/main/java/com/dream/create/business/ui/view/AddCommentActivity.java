package com.dream.create.business.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.dream.create.R;
import com.dream.create.databinding.ActivityAddCommentLayoutBinding;
import com.dream.create.framework.BaseActivity;

public class AddCommentActivity extends BaseActivity implements View.OnClickListener {
    private ActivityAddCommentLayoutBinding mActivityAddCommentLayoutBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityAddCommentLayoutBinding = ActivityAddCommentLayoutBinding.inflate(getLayoutInflater());
        setContentView(mActivityAddCommentLayoutBinding.getRoot());
        initView();
    }

    public void initView(){
        mActivityAddCommentLayoutBinding.tvPublishAddComment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_publish_add_comment:
                Intent t = new Intent();
                t.putExtra("comment",mActivityAddCommentLayoutBinding.etAddComment.getText().toString());
                setResult(RESULT_OK,t);
                finish();
                break;
            default:
                break;
        }
    }
}
