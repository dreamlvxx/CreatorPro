package com.dream.create.utils;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

public class ViewModelUtils {
    public static <T extends ViewModel> T getViewModel(ViewModelStoreOwner owner, Class<T> clazz){
        return new ViewModelProvider(owner).get(clazz);
    }
}
