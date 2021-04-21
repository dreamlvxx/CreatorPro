package com.dream.create.framework;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public abstract class BaseViewModel extends AndroidViewModel {
    protected Context mContext;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mContext = application;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
