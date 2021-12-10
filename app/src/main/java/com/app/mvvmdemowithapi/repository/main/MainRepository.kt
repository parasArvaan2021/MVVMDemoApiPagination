package com.app.mvvmdemowithapi.repository.main

import com.app.mvvmdemowithapi.respone.main.PaginationResponse
import com.app.mvvmdemowithapi.service.RetrofitService
import retrofit2.Response

class MainRepository constructor(
    private val retrofitService: RetrofitService
) {
    suspend fun getData(pageNo: Int):Response<PaginationResponse> {

        return retrofitService.getPaginationData("Bearer " +
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImZiZTA0NDQ5ZjE0ZmVkNGZhNWU0MjBlZTAzZjk4YWViZjRjOTRmZWMwMTlhZmFjOTJhYjJkOTZmNDY1YjQ1ZjJkY2U1Y2QwNzJhMjMwNGQwIn0.eyJhdWQiOiI3IiwianRpIjoiZmJlMDQ0NDlmMTRmZWQ0ZmE1ZTQyMGVlMDNmOThhZWJmNGM5NGZlYzAxOWFmYWM5MmFiMmQ5NmY0NjViNDVmMmRjZTVjZDA3MmEyMzA0ZDAiLCJpYXQiOjE2Mzg3ODgyNDgsIm5iZiI6MTYzODc4ODI0OCwiZXhwIjoxNjcwMzI0MjQ4LCJzdWIiOiIyOTAiLCJzY29wZXMiOltdfQ.phbb0wqR1zsa27YXIWpe5cHULnsXl10xEXcSXsvPKY-jkMb5Xk0YptbFunm2q-Eax8L4Tm5ffFp97GbsivfJyELr4-XC4AjQo5XUh4l9Q0zRfctBDfSEKnT0gu8Uy35aQFKakrIHMXyFZK_SyYcq4Yfltnp5AR62c69JzOX4_H0cch8sQ2tlpTxWD48fsnb5LeVzSp31EYXdh_KlEowpGQVXjxdVWvxrgEVqI01PE183EuaZym8N-pIp69AcPghsRxvlFeQEFhxcIqyV9As-4R-pWydyuJljtaJl084kkKzbDKsatWjX_Rqt8-RnAbNgmVuy2IPcOBgNMQypNnGi2b6b6-VyX0iMd5HH8jVmUsffJi6ty_1cvKMMJTGqCIBHUsFdtxSNJuus24SxaGAVK9yVluuY77lf0HhuLp4aTpS-LQ9NlpU_2f40309sL1etDcm0vwutWJnbMeKmQm1tdu3CagCQ9KpYXZOlr-zPpyZxUd3OvyN8Bt5o2o1M_1umZUaZFMDC7nmarrcoUApsvj812RKJVwYR4hHUfva_TA3WpDM7deaqo1_v2eU6v1UopwYVIHa5E7kPhnC6JPrfoB7Qv_MF3bgYIzfekztl20cvItP0_-6Nrtw_XF8kUzDkSTj7BRnpJTCpF3_DiH_TMuFWKA065knuoHklT6HHwV4",pageNo.toString())
    }

}
