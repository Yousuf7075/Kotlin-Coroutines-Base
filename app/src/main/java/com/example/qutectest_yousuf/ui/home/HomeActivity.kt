package com.example.qutectest_yousuf.ui.home

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.qutectest_yousuf.R
import com.example.qutectest_yousuf.base.BaseActivity
import com.example.qutectest_yousuf.databinding.ActivityHomeBinding
import com.example.qutectest_yousuf.factory.ViewModelProviderFactory
import com.example.qutectest_yousuf.ui.home.model.HomeDataRP
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
        observeViewModel()
    }

    private fun observeViewModel() {
        homeViewModel.homeDataResponse.observe(this, Observer {
            Log.e("res",it.toString())
            initUi(it)
        })
    }

    private fun initUi(data: HomeDataRP) {

    }
}