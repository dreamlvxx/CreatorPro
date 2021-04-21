package com.dream.create.framework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import com.dream.create.utils.ViewModelUtils;

public abstract class BaseActivity extends AppCompatActivity {
    protected  <T extends ViewModel> T getActivityViewModel(Class<T> clazz){
        return ViewModelUtils.getViewModel(this,clazz);
    }
}
