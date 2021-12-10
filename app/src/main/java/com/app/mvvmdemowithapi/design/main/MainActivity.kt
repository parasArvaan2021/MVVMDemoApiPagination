package com.app.mvvmdemowithapi.design.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mvvmdemowithapi.R
import com.app.mvvmdemowithapi.base.BaseActivity
import com.app.mvvmdemowithapi.base.Status
import com.app.mvvmdemowithapi.databinding.ActivityMainBinding
import com.app.mvvmdemowithapi.design.main.adapter.MainDataSetImageAdapter
import com.app.mvvmdemowithapi.repository.main.MainRepository
import com.app.mvvmdemowithapi.respone.main.PaginationResponse

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)
    lateinit var viewModel: MainActivityViewModel
    lateinit var mainDataSetImageAdapter: MainDataSetImageAdapter
    private var currentPage = 1
    private var totalPage = 0
    var apiCallOrNot=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDataSetImageAdapter = MainDataSetImageAdapter(this)
        binding.apply {
            lifecycleOwner = this@MainActivity
            rvMainData.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = mainDataSetImageAdapter

                setHasFixedSize(true)
            }
        }
        viewModel = ViewModelProvider(
            this,
            MainActivityModelFactory(
                MainRepository(
                    retrofitService
                )
            )
        ).get(MainActivityViewModel::class.java)
        initView()

        binding.rvMainData.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val layoutManager = LinearLayoutManager::class.java.cast(recyclerView.layoutManager)
                val totalItemCount = layoutManager.itemCount
                val lastVisible = layoutManager.findLastCompletelyVisibleItemPosition()
                Log.e("TAG", "onScrollStateChanged: rvTotoalItem:$totalItemCount  rvlastpos:$lastVisible currentPage:$currentPage totalpage:$totalPage")
                if (currentPage != totalPage && lastVisible == totalItemCount-1 && apiCallOrNot) {
                    currentPage++
                    apiCallOrNot=false
                    viewModel.getData(currentPage)
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }

        })

        viewModel.getData(currentPage)

    }

    fun initView() {
        viewModel.dataShow.observe(this, {
            when (it.status) {
                Status.ERROR -> {
                    binding.progressCircular.visibility = View.GONE
                    Log.e("TAG", "initView: ${it.error}")
                }
                Status.SUCCESS -> {
                    binding.progressCircular.visibility = View.GONE
                    Log.e("TAG", "initView: ${it.response}")
                    if (it.response?.data?.data != null) {
                        totalPage = it.response.data.lastPage!!
                        apiCallOrNot=true
                        if (currentPage == 1) {
                            mainDataSetImageAdapter.setListOfImageData(it.response.data.data as ArrayList<PaginationResponse.Data.Data>)
                        } else {
                            mainDataSetImageAdapter.addDataInLastPosition(it.response.data.data as ArrayList<PaginationResponse.Data.Data>)
                        }


                    }
                }
                Status.LOADING -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }


                else -> {
                    binding.progressCircular.visibility = View.GONE
                    Log.e("TAG", "initView: else")
                }
            }
        })
    }

}