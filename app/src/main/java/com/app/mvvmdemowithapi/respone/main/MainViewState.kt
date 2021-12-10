package com.app.mvvmdemowithapi.respone.main

import com.app.mvvmdemowithapi.base.BaseViewState
import com.app.mvvmdemowithapi.base.Status

class MainViewState(
    val status: Status,
    val error: String? = null,
    val response: PaginationResponse? = null
) : BaseViewState(status, error)
