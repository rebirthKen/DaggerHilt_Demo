package com.example.mvi_daggerhilt_demo.ui

import android.service.autofill.Dataset
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mvi_daggerhilt_demo.model.Blog
import com.example.mvi_daggerhilt_demo.repository.MainRepository
import com.example.mvi_daggerhilt_demo.util.DataState

class MainViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _dataState: MutableLiveData<DataState<List<Blog>>> = MutableLiveData()

    val dataset: LiveData<DataState<List<Blog>>>
    get()  = _dataState


}

sealed class MainStateEvent {
    object  GetBlogEvents: MainStateEvent()
    object None: MainStateEvent()
}