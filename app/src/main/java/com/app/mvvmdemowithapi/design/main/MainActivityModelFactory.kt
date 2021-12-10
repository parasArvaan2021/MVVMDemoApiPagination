package com.app.mvvmdemowithapi.design.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.mvvmdemowithapi.repository.main.MainRepository

class MainActivityModelFactory constructor(val repository:MainRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            MainActivityViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}