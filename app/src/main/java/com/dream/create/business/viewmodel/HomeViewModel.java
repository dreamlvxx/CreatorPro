package com.dream.create.business.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.dream.create.business.ui.entity.HomeListEntity;
import com.dream.create.framework.BaseViewModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class HomeViewModel extends BaseViewModel {
    private static final String TAG = "HomeViewModel";
    private MutableLiveData<HomeListEntity> homeListData;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<HomeListEntity> getListData() {
        if (null == homeListData) {
            homeListData = new MutableLiveData<>();
            loadData();
        }
        return homeListData;
    }

    private void loadData() {
        InputStream is = null;
        try {
            is = mContext.getAssets().open("hom_data.json");
            int lenght = is.available();
            byte[] buffer = new byte[lenght];
            is.read(buffer);
            String result = new String(buffer, "utf8");
            Log.e(TAG, "loadData: " + result);
            HomeListEntity entilist = new Gson().fromJson(result, HomeListEntity.class);
            homeListData.setValue(entilist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
