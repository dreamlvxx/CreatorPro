package com.dream.create.framework;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.dream.create.utils.ViewModelUtils;

public class BaseFragment extends Fragment {

    protected  <T extends ViewModel> T getActivityViewModel(Class<T> clazz){
        return ViewModelUtils.getViewModel(this,clazz);
    }
}
