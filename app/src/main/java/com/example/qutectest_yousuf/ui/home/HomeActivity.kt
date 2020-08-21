package com.example.qutectest_yousuf.ui.home

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qutectest_yousuf.R
import com.example.qutectest_yousuf.base.BaseActivity
import com.example.qutectest_yousuf.databinding.ActivityHomeBinding
import com.example.qutectest_yousuf.factory.ViewModelProviderFactory
import com.example.qutectest_yousuf.ui.home.model.Data
import com.example.qutectest_yousuf.ui.home.model.HomeDataRP
import com.example.qutectest_yousuf.utils.CustomRecyclerItemSpaceDecoration
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    lateinit var homeBinding: ActivityHomeBinding

    private lateinit var homeViewModel: HomeViewModel
    @set:Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        setSupportActionBar(homeBinding.toolbar)
        homeBinding.toolbar.title = "Home"

        homeViewModel = ViewModelProviders.of(this, providerFactory)[HomeViewModel::class.java]
        showLoading()
        observeViewModel()
    }

    private fun observeViewModel() {
        homeViewModel.homeDataResponse.observe(this, Observer {
            hideLoading()
            Log.e("res",it.toString())
            initAdapter(it.data as ArrayList<Data>)
        })
    }

    private fun initAdapter(items: ArrayList<Data>) {
        homeBinding.homeRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        homeBinding.homeRecycler.setHasFixedSize(true)
        val itemSpaceDecoration = CustomRecyclerItemSpaceDecoration(35,10,35,35,40,0)
        homeBinding.homeRecycler.addItemDecoration(itemSpaceDecoration)
        val adapter = HomeAdapter(items)
        homeBinding.homeRecycler.adapter = adapter
    }
}