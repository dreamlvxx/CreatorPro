package com.dream.create.framework.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : AndroidViewModel(application) {

    init {
        viewModelScope.launch {

        }

        var result: StateFlow<String> = flow {
            emit("sad")
        }.stateIn(
                scope = viewModelScope,
                started = WhileSubscribed(5000), //由于是一次性操作，也可以使用 Lazily
                initialValue = "init"
        )


        viewModelScope.launch {
            result.onStart {

            }.catch {

            }.onCompletion {

            }.collectLatest {

            }
        }


        viewModelScope.launch {
            result.collect {

            }

        }

        fun getMessag() = liveData<String> {
            result.onStart {

            }.collectLatest {
                emit(it)
            }
        }
    }
}