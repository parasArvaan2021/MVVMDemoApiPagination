package com.app.mvvmdemowithapi.design.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.mvvmdemowithapi.base.Status
import com.app.mvvmdemowithapi.repository.main.MainRepository
import com.app.mvvmdemowithapi.respone.main.MainViewState
import kotlinx.coroutines.*

class MainActivityViewModel constructor(val repository: MainRepository): ViewModel() {

    val whichPageDataShow = MutableLiveData<MainViewState>()

    val dataShow: LiveData<MainViewState>
        get() {
            return whichPageDataShow
        }


    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        whichPageDataShow.postValue(
            MainViewState(
                Status.ERROR,
                "Error : ${throwable.localizedMessage} "
            )
        )
    }

    fun getData(pageNo:Int) {
        whichPageDataShow.postValue(
            MainViewState(
                Status.LOADING,
                null,
                null
            )
        )
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

            val response = repository.getData(pageNo)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    whichPageDataShow.postValue(
                        MainViewState(
                            Status.SUCCESS,
                            null,
                            response.body()
                        )
                    )
                } else {
                    whichPageDataShow.postValue(
                        MainViewState(
                            Status.ERROR,
                            "Error:${response.message()}"
                        )
                    )
                }
            }

        }

    }


}