package com.app.mvvmdemowithapi.base

import android.os.Bundle
import com.app.mvvmdemowithapi.service.RetrofitService
import com.app.mvvmdemowithapi.utils.PrefUtils

open class BaseActivity : DataBindingActivity() {

    lateinit var objSharedPref: PrefUtils
    lateinit var retrofitService: RetrofitService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        objSharedPref = PrefUtils(this@BaseActivity)
        retrofitService = RetrofitService.getInstance()
    }
}

