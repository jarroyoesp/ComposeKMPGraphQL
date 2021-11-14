package com.jarroyo.composekmpgraphql.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarroyo.composekmpgraphql.model.UIHomeState
import kotlinx.coroutines.launch
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import com.jarroyo.sharedcodeclient.domain.usecase.GetHomeDataUsecase
import com.jarroyo.sharedcodeclient.di.*
import com.jarroyo.sharedcodeclient.domain.model.CharacterUIModel

class HomeViewModel @ViewModelInject constructor(
) : ViewModel() {
    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }

    private val getHomeDataUsecase: GetHomeDataUsecase = Injector().getHomeDataUsecase

    private var _homeState = MutableLiveData<UIHomeState>()
    val homeState: LiveData<UIHomeState>
        get() {
            if (_homeState.value == null) getHomeData()
            return _homeState
        }

    fun getHomeData() = viewModelScope.launch {
        _homeState.value = UIHomeState.ShowLoading

        getHomeDataUsecase.invoke().fold(
            {
                _homeState.value = UIHomeState.HideLoading
                _homeState.value = UIHomeState.Error(it)
            },
            { list ->
                _homeState.value = UIHomeState.HideLoading
                if (list.isNullOrEmpty()) {
                    _homeState.value = UIHomeState.NoContents
                } else {
                    _homeState.value = UIHomeState.ShowData(list)
                }
            }
        )
    }



    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}